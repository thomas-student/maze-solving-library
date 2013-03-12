package fileIOTools.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.image.BufferedImage;

import maze.Maze;
import maze.impl.EuclideanBooleanMazeImpl;

import org.junit.Test;
import org.mockito.Mockito;

import fileIOTools.ImageFileIOService;

/**
 * Tests the functionality of ImageFileIOService class.
 * 
 * @author Thomas Johnston
 */
public class TestImageFileIOService {

	//The max a RGB value can hold
	private static double RGB_MAX_VALUE = 255.0;

	/**
	 * Test the getBooleanArray method, by using the Mockito Library to mock a Buffered Image and
	 * using it to test the maze extraction.
	 */
	@Test
	public void testGetBooleanArray() {
		//Setup a mock Buffered Image with the deepening grayscale as the row increases
		BufferedImage image = Mockito.mock(BufferedImage.class);
		Mockito.when(image.getWidth()).thenReturn(5);
		Mockito.when(image.getHeight()).thenReturn((int) RGB_MAX_VALUE);
		for(int x = 0; x < 5; x++)
			for(int y = 0; y < RGB_MAX_VALUE; y++)
				Mockito.when(image.getRGB(x, y)).thenReturn(new Color(y, y, y).getRGB());
		
		//Exctract the boolean array using ImageFileIOService.getBooleanArray
		boolean[][] array = ImageFileIOService.getBooleanArray(image);
		
		//Ensure that each space is valid iff the pixel is "more gray" than GRAYSCALE_THRESHOLD 
		for(int row = 0; row < array.length; row++)
			for(int col = 0; col < array[0].length; col++)
				if((double)row/RGB_MAX_VALUE < ImageFileIOService.GRAYSCALE_THRESHOLD)
					assertTrue("Space should be walkable", array[row][col]);
				else
					assertFalse("Space shouldn't be walkable", array[row][col]);
	}

	
	/**
	 * Test that the ImageFileIOService.printMazeToImage successfully prints to an Image
	 */
	@Test
	public void testPrintMazeToImage() {
		//Start with the following boolean array
		boolean[][] array = { {true, 	false,	true } ,
							  {true, 	true, 	false} ,
							  {false,   true, 	true } };
		//Generate maze from the boolean array
		Maze maze = new EuclideanBooleanMazeImpl(array);
		//Hard-code solution to prevent bugs in solving library from effecting the output
		int[][] sol = { {0,0}, {1,1}, {2,2} };
		//Generate image by using the ImageFileIOService.printMazeToImage method
		BufferedImage image = (BufferedImage) ImageFileIOService.printMazeAndSolutionToImage(maze, sol);
		
		//Check that the Image has the correct colored pixels
		assertEquals("Space should be red", image.getRGB(0, 0), Color.RED.getRGB());
		assertEquals("Space should be red", image.getRGB(1, 1), Color.RED.getRGB());
		assertEquals("Space should be red", image.getRGB(2, 2), Color.RED.getRGB());
		assertEquals("Space should be black", image.getRGB(2, 0), Color.BLACK.getRGB());
		assertEquals("Space should be black", image.getRGB(0, 1), Color.BLACK.getRGB());
		assertEquals("Space should be black", image.getRGB(1, 2), Color.BLACK.getRGB());
		assertEquals("Space should be black", image.getRGB(1, 0), Color.WHITE.getRGB());
		assertEquals("Space should be black", image.getRGB(2, 1), Color.WHITE.getRGB());
		assertEquals("Space should be black", image.getRGB(0, 2), Color.WHITE.getRGB());
	}
}
