package mvc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;

import maze.Maze;
import maze.impl.DiagonalBooleanMazeImpl;
import maze.impl.EuclideanBooleanMazeImpl;
import maze.impl.ManhattanBooleanMazeImpl;
import mazeSolver.impl.aStar.AStarMazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;
import mvc.cmd.MazeSolverCMDView;
import fileIOTools.ImageFileIOService;

/**
 * The main controller for the MazeSolver MVC architecture
 * 
 * @author Thomas Johnston
 */
public class MazeSolverController extends JApplet{

	//Various constants for defining heuristics and pathfinding algorithms
	public static final int EUCLIDEAN_HEURISTIC = 0x1;
	public static final int MANHATTAN_HEURISTIC = 0x2;
	public static final int DIAGONAL_HEURISTIC = 0x3;
	public static final int ASTAR_SOLVER = 0x1;
	public static final int DIJKSTRA_SOLVER = 0x2;
	
	//A reference to the model and view
	protected MazeSolverModel model;
	
	
	protected View view;

	
	/**
	 * Changes the heuristic, returning a boolean based on whether the heuristic was changed
	 * 
	 * @param heuristic The heuristic (Note: Should be one of the heuristic constants)
	 * @return A boolean signifying the success
	 */
	public boolean changeHeuristic(int heuristic){
		try{
			if(model.getMaze() == null)
				return false;
			//Set the model's maze depending on the heuristic
			switch(heuristic){
				case EUCLIDEAN_HEURISTIC:
				{
					model.setMaze(new EuclideanBooleanMazeImpl((model.getMaze()).getSpaces()) );
					break;
				}
				case DIAGONAL_HEURISTIC:
				{
					model.setMaze(new DiagonalBooleanMazeImpl((model.getMaze()).getSpaces()) );
					break;
				}
				case MANHATTAN_HEURISTIC:
				{
					model.setMaze(new ManhattanBooleanMazeImpl((model.getMaze()).getSpaces()) );
					break;
				}
			}
			//Reset the solutions array to signify that the maze has now not been solved
			notifyViewOfChange();
		}
		//Catch all exceptions and return false on them
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Solves the maze
	 * 
	 * @return True if the maze was attempted successfully (Not if it was solved necessarily)
	 */
	public boolean solveMaze(){
		try{
			if(model.getMaze() == null || model.getSolver() == null)
				return false;
			int[][] solution = model.getSolver().solveMaze(model.getMaze());
			model.setSolutions(solution);			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Inputs and processes a new image as the src image for the Maze
	 * @param fname The name of the image file
	 * @return Whether or not the maze could be imported/processed
	 */
	public boolean inputImage(File file){
		try{
			//Read the image from file
			BufferedImage image = ImageIO.read(file);
			model.setSrcImage(image);
			model.setMaze(new EuclideanBooleanMazeImpl(image));

		}
		//Catch all exceptions, reset the solution and return false
		catch(Exception e){
			notifyViewOfChange();
			return false;
		}
		//Reset the solution and return false
		notifyViewOfChange();
		return true;
	}
	
	/**
	 * Changes the pathfinding alg, returning a boolean based on whether the pathfinding alg was changed
	 * 
	 * @param solver The pathfinding algorithm (Note: Should be one of the pathfinding alg constants)
	 * @return A boolean signifying the success
	 */
	public boolean changeSolver(int solver){
		try{
			if(model.getMaze() == null)
				return false;
			//Based on the input of the solver update the solver in the model
			switch(solver){
				case ASTAR_SOLVER:
				{
					model.setSolver(new AStarMazeSolver());
					break;
				}
				case DIJKSTRA_SOLVER:
				{
					model.setSolver(new DijkstraMazeSolver());
					break;
				}
			}
		}
		//Catch all exceptions, reset the solution and return false
		catch(Exception e){
			notifyViewOfChange();
			return false;
		}
		//Notify the view there was a change
		notifyViewOfChange();
		return true;
	}

	/**
	 * Print the maze from the model to file
	 * 
	 * @param maze The maze
	 * @param solution The solution (or null for no solution)
	 * @param fname The name of the output file
	 * @return A boolean, whether or not the maze was able to be printed to file
	 */
	public boolean printMazeToFile(Maze maze, int[][] solution, String fname) {
		//Read the image
		BufferedImage image = null;
		//If there is no solution print the maze without solution
		if(solution == null)
			image = (BufferedImage) ImageFileIOService.printMazeToImage(maze);
		//If there is a solution print the maze with the solution
		else
			image = (BufferedImage) ImageFileIOService.printMazeAndSolutionToImage(maze, solution);
		//If the image is null after this there has been an error so return false
		if(image == null)
			return false;
		//Otherwise try and save the Image to file
		else
			try {
				ImageIO.write(image, "bmp", new File(fname));
			} 
			//Catch the IOException and return false
			catch (IOException e) {
				return false;			
			}
		return true;
	}
	
	/**
	 * Resets the solutions in the model and notifies the View that there was a change
	 */
	private void notifyViewOfChange(){
		model.setSolutions(null);
		view.notifyOfChange();
	}
	
	/**
	 * @param file Save the image to a file, saving it with the solution if available
	 */
	public void outputImage(File file){
		//Ensure maze isn't null
		if(model.getMaze() == null)
			return;
		BufferedImage toprint;
		//If there is no source image print a boolean representation of the maze with the solution overlayed onto it if it exists
		if(model.getSrcImage() == null)
			if(model.getSolutions() == null)
				toprint = ImageFileIOService.printMazeToImage(model.getMaze());
			else
				toprint = (BufferedImage) ImageFileIOService.printMazeAndSolutionToImage(model.getMaze(), model.getSolutions());
		//Otherwise print the source image with the solution overlayed onto it if it exists
		else
			{
			toprint = model.getSrcImage();
			if(model.getSolutions() != null)
				toprint = ImageFileIOService.overlaySolutionOntoImage(toprint, model.getSolutions());
			}
		//Finally write the image to a file (in bmp format)
		try {
			ImageIO.write(toprint, "bmp", file);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	/**
	 * Tests to see if the current maze in the model is solvable returning false if the maze or solver
	 * are not initialized.
	 * 
	 * @return Whether or not the maze is solvable.
	 */
	public boolean isSolveable(){
		//Ensure the model's maze and solver are not null. 
		if(model.getMaze() == null || model.getSolver() == null)
			return false;
		int[][] solution = model.getSolver().solveMaze(model.getMaze());
		return (solution != null && solution.length > 0);
	}
	
	/**
	 * @return the model
	 */
	public MazeSolverModel getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(MazeSolverModel model) {
		this.model = model;
	}

	/**
	 * @return the view
	 */
	public View getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(View view) {
		this.view = view;
	}


}