package maze.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import maze.Maze;
import maze.impl.ManhattanBooleanMazeImpl;

import org.junit.Test;

/**
 * Tests the Diagonal Boolean Maze implementation.
 * 
 * @author Thomas Johnston
 */
public class ManhattanBooleanMazeImplTest {

	@Test
	public void testManhattanBooleanMazeImpl() {
		boolean[][] m = { {true, false, true},
				  		{true, true, false},
				  		{false, true, true} };
		ManhattanBooleanMazeImpl maze = new ManhattanBooleanMazeImpl(m);
		for(int c = 0; c < m.length; c++)
			for(int r = 0; r < m[0].length; r++)
				assertEquals(m[r][c], maze.isValid(r, c));
	}

	@Test
	public void testGetValidAdjacentSpaces() {
		Maze maze = new ManhattanBooleanMazeImpl();
		int[][] spaces = maze.getValidAdjacentSpaces(0, 0);
		for(int[] coordinate : spaces)
			assertEquals("Valid Spaces", true, maze.isValid(coordinate[0], coordinate[1]));
	}

	@Test
	public void testGetDistanceBetweenSpaces() {
		Maze maze = new ManhattanBooleanMazeImpl();
		assertTrue(maze.getDistanceBetweenSpaces(0, 0, 2, 3)==5);
	}

	@Test
	public void testIsValid() {
		Maze maze = new ManhattanBooleanMazeImpl();
		assertTrue(maze.isValid(0, 0));
	}
}