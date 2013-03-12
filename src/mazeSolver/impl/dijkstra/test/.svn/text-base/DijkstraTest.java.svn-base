package mazeSolver.impl.dijkstra.test;

import static org.junit.Assert.assertNotNull;
import maze.impl.DiagonalBooleanMazeImpl;
import mazeSolver.MazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;

import org.junit.Test;

import fileIOTools.PlaintextFileIOService;

/**
 * Tests the DijkstraMazeSolver
 * 
 * @author Thomas Johnston
 */
public class DijkstraTest {

	/**
	 * Tests the DijkstraMazeSolver
	 */
	@Test
	public void test() {
		boolean[][] m = { {true, false, true},
		  				{true, true, false},
		  				{false, true, true} };
		DiagonalBooleanMazeImpl maze = new DiagonalBooleanMazeImpl(m);
		MazeSolver solver = new DijkstraMazeSolver();
		int[][] solution = solver.solveMaze(maze);
		PlaintextFileIOService.printMazeToFile(maze, "maze.txt");
		//Check maze solved
		assertNotNull(solution);
	}
}