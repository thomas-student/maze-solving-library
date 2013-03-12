package mvc.test;

import static org.junit.Assert.*;

import mvc.MazeSolverController;
import mvc.gui.GUIControl;

import org.junit.Test;

public class TestMazeSolverController {

	@Test
	public void testChangeHeuristic() {
		MazeSolverController control = new GUIControl();
		control.changeHeuristic(MazeSolverController.EUCLIDEAN_HEURISTIC);
	}

	@Test
	public void testSolveMaze() {
		fail("Not yet implemented");
	}

	@Test
	public void testInputImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testChangeSolver() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintMazeToFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testOutputImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSolveable() {
		fail("Not yet implemented");
	}

}
