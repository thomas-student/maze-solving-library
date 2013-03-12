/**
 * 
 */
package fileIOTools.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import maze.impl.DiagonalBooleanMazeImpl;
import mazeSolver.MazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;

import org.junit.Test;

import fileIOTools.PlaintextFileIOService;

/**
 * Test the PlaintextFileIOService class
 * 
 * @author Thomas Johnston
 */
public class TestPlaintextFileIOService {

	/**
	 * Test method for {@link fileIOTools.PlaintextFileIOService#printMazeToFile(maze.Maze, java.lang.String)}.
	 */
	@Test
	public void testPrintMazeToFile() {
			boolean[][] m = { {true, false, true},
	  						{true, true, false},
	  						{false, true, true} };
			DiagonalBooleanMazeImpl maze = new DiagonalBooleanMazeImpl(m);
			PlaintextFileIOService.printMazeToFile(maze, "maze.txt");
			boolean exists = new File("maze.txt").exists();
			//Check file output correctly
			assertTrue("Result", exists);
		}
	

	/**
	 * Test method for {@link fileIOTools.PlaintextFileIOService#printMazeSolutionToFile(maze.Maze, java.lang.String, int[][])}.
	 */
	@Test
	public void testPrintMazeSolutionToFile() {
			boolean[][] m = { {true, false, true},
	  						{true, true, false},
	  						{false, true, true} };
			DiagonalBooleanMazeImpl maze = new DiagonalBooleanMazeImpl(m);
			MazeSolver solver = new DijkstraMazeSolver();
			int[][] solution = solver.solveMaze(maze);
			PlaintextFileIOService.printMazeSolutionToFile(maze, "maze.txt", solution);
			boolean exists = new File("maze.txt").exists();
			assertTrue("Result", exists);
	}

}
