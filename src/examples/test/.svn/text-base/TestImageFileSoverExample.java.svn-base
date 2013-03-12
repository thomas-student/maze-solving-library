package examples.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import examples.ImageFileSolverExample;

/**
 * Tests the ImageFileSolverExample class. 
 * 
 * NOTE: If this is the only test to fail the problem is an IOException most likely caused by the
 * images example folder not being in the project root folder.
 * 
 * @author Thomas Johnston
 */
public class TestImageFileSoverExample {

	/**
	 * Tests the main method of the ImageFileSolverExample class. 
	 */
	@Test
	public void testMain() {
		try{
		//Call the main method of the ImageFileSolverExample class (not testing large maze)
		ImageFileSolverExample.main(null);
		}
		catch(IOException e){
			//Fail on an IOException (image files not found or program not able to save files)
			fail("IOException in ImageFileSolverExample class, most likely images file not found" +
					" in main directory");
		}
	}

}
