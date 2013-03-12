package examples;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import maze.Maze;
import maze.impl.EuclideanBooleanMazeImpl;
import mazeSolver.MazeSolver;
import mazeSolver.impl.aStar.AStarMazeSolver;
import fileIOTools.ImageFileIOService;

/**
 * A basic example/tutorial of the MazeSolving Library. This example reads in the example images
 * that come with the zip download, solves them using Dykstra's Algorithm and a Euclidean Distance
 * Formula and then saves them as different files.
 * 
 * NOTE: File IO is not directly included in the MazeSolving Library, this is to allow the library 
 * to focus development and resources on maze solving and generalize io's to allow for many uses.
 * 
 * @author Thomas Johnston
 *
 */
public class ImageFileSolverExample {

	/**
	 * The main method that the solveMazeFromFile method to read, solve, and print mazes to display
	 * functionality and use of the MazeSolverLibrary.
	 * 
	 * NOTE: To add the functionality of the large maze test (a 2000x2000 condensed maze) the first 
	 * argument must be the string "large"
	 * 
	 * @param args The runtime arguments (large maze tested iff args[0] == "large")
	 * @throws IOException If there is an IOException, (most likely that the images example folder does
	 * 					   																	 not exist)
	 */
	public static void main(String[] args) throws IOException{
		solveMazeFromFile("C:/Users/Thomas/cs242Workspace/GUIMazeSolvingLibrary/images/maze0.bmp", "images/maze1-sol.bmp");
		solveMazeFromFile("images/maze1.bmp", "images/maze2-sol.bmp");
		solveMazeFromFile("images/maze2.bmp", "images/maze3-sol.bmp");
		if (args!= null && args.length > 0 && args[0].equals("large"))
			solveMazeFromFile("images/largemaze.bmp", "images/largemaze-sol.bmp");
		solveMazeFromFile("images/shortestRouteTest.bmp", "images/shortestRouteTest-sol.bmp");
	}
	
	/**
	 * The most important method of the class. This method exhibits the use of the MazeSolving library.
	 * This is a good starting point for using the MazeSolving Library.
	 * 
	 * @param inFilename The filename of the input maze
	 * @param outFilename The filename of the output maze
	 * @throws IOException If the files are not found
	 */
	private static void solveMazeFromFile(String inFilename, String outFilename) throws IOException{
		//Read in the file and extract maze
		System.out.println("[Image:'"+inFilename+"] Reading...");
		BufferedImage image = ImageIO.read(new File(inFilename));
		boolean[][] array = ImageFileIOService.getBooleanArray(image);
		Maze maze = new EuclideanBooleanMazeImpl(array);
		
		//Initialize solver and solve maze
		MazeSolver solver = new AStarMazeSolver();
		System.out.println("[Image:'"+inFilename+"] Solving...");
		int[][] solution = solver.solveMaze(maze);
		
		//Generate and save solution image to file
		Image solutionImage = ImageFileIOService.printMazeAndSolutionToImage(maze, solution);
		ImageIO.write((RenderedImage) solutionImage, "bmp", new File(outFilename));
		System.out.println("[Image:'"+inFilename+"] Finished!");
	}
}
