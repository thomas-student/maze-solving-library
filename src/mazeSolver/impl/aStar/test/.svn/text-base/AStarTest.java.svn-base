package mazeSolver.impl.aStar.test;

import static org.junit.Assert.assertNotNull;
import maze.impl.DiagonalBooleanMazeImpl;
import mazeSolver.MazeSolver;
import mazeSolver.impl.aStar.AStarMazeSolver;

import org.junit.Test;

import fileIOTools.PlaintextFileIOService;

/**
 * Tests the A* algorithm on a basic maze.
 * 
 * @author Thomas Johnston
 */
public class AStarTest {

	/**
	 * Tests the A* algorithm on a basic maze.
	 */
	@Test
	public void test() {
		boolean[][] m = { {true, false, true},
		  				{true, true, false},
		  				{false, true, true} };
		DiagonalBooleanMazeImpl maze = new DiagonalBooleanMazeImpl(m);
		MazeSolver solver = new AStarMazeSolver();
		int[][] solution = solver.solveMaze(maze);
		PlaintextFileIOService.printMazeToFile(maze, "maze.txt");
		//Check maze solved
		assertNotNull(solution);
	}

}
