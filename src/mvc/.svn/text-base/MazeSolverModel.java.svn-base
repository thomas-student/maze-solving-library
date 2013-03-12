package mvc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import maze.Maze;
import maze.impl.EuclideanBooleanMazeImpl;
import mazeSolver.MazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;

/**
 * The model for the Maze Solver's Model-View-Controller Architecture
 * 
 * @author Thomas Johnston
 */
public class MazeSolverModel {

	//The variables stored in the model
	private Maze maze;
	private MazeSolver solver;
	private BufferedImage srcImage;
	private int[][] solutions;
	
	
	/**
	 * The only constructor for the MazeSolverModel. Instantiates everything in the model to null
	 */
	public MazeSolverModel(){
		srcImage = null;
		maze = null;
		solver = null;
		solutions = null;
	}
	
	/**
	 * @return the maze
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * @param maze the maze to set
	 */
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	/**
	 * @return the solver
	 */
	public MazeSolver getSolver() {
		return solver;
	}
	
	/**
	 * @param solver the solver to set
	 */
	public void setSolver(MazeSolver solver) {
		this.solver = solver;
	}
	
	/**
	 * @return the srcImage
	 */
	public BufferedImage getSrcImage() {
		return srcImage;
	}
	
	/**
	 * @param srcImage the srcImage to set
	 */
	public void setSrcImage(BufferedImage srcImage) {
		this.srcImage = srcImage;
	}

	/**
	 * @return The solution
	 */
	public int[][] getSolutions() {
		return solutions;
	}

	/**
	 * @param solutions The solution to set
	 */
	public void setSolutions(int[][] solutions) {
		this.solutions = solutions;
	}
}