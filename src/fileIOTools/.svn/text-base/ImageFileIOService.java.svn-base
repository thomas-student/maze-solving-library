package fileIOTools;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import maze.Maze;

/**
 * The class that provides the services of extracting Mazes from Images and printing Mazes (and/or
 * solutions) to Buffered Images
 * 
 * @author Thomas Johnston
 */
public class ImageFileIOService {
	
	//The threshold at which a pixel is gray
	public static final double GRAYSCALE_THRESHOLD = .4;

	/**
	 * Extracts a 2D boolean array representing space validity from the BufferedImage parameter, 
	 * counting pixels with a grayscale under the constant GRAYSCALE_THRESHOLD as valid or "walkable"
	 * 
	 * @param image The image to extract the array from
	 * @return The resulting 2D boolean array extracted from the image
	 */
	public static boolean[][] getBooleanArray(BufferedImage image) {
		
		//Declare the 2D boolean array
		boolean[][] maze = new boolean[image.getHeight()][image.getWidth()];
		
		//For each space in the array, if the cooresponding pixel is under the threshold make it true
		for(int row = 0; row < maze.length; row++)
			for(int col = 0; col < maze[0].length; col++)
			{
				//Extract color and corresponding grayscale then normalize to a percentage
				Color pixelColor = new Color(image.getRGB(col, row));
				double grayScale = (pixelColor.getRed() + pixelColor.getGreen() + pixelColor.getBlue());
				grayScale /= 3.0;
				grayScale /= 255.0;
				//If under GRAYSCALE_THRESHOLD then make array entry true.
				if(grayScale < GRAYSCALE_THRESHOLD)
					maze[row][col] = true;
			}
		
		//Return the 2D array
		return maze;
	}
	
	public static Image printMazeAndSolutionToImage(Maze maze, int[][] solution){
		//Print the maze to an image
		BufferedImage image = (BufferedImage) printMazeToImage(maze);
		//Overlay the solution and return the resulting image
		return (BufferedImage) overlaySolutionOntoImage(image, solution);
	}
	
	/**
	 * Prints a maze onto an image. Each space in the maze is one pixel in the resulting
	 * Image and it is colored black if walkable, white if un-walkable and red if part of the solution
	 * 
	 * @param maze
	 * @param solution
	 * @return The image with the Maze overlayed onto it
	 */
	public static BufferedImage printMazeToImage(Maze maze){
		//Initialize the image
		BufferedImage image = new BufferedImage(maze.getWidth(), maze.getHeight(), BufferedImage.TYPE_INT_RGB);
		//For each space in the maze paint the corresponding pixel black
		for(int row = 0; row < maze.getHeight(); row++)
			for(int col = 0; col < maze.getWidth(); col++)
				if(maze.isValid(row, col))
					image.setRGB(col, row, Color.BLACK.getRGB());
				else
					image.setRGB(col, row, Color.WHITE.getRGB());
		//Overlay solution onto the image and return it
		return image;
	}	
	
	/**
	 * Overlay's a solution onto an image by painting the pixels denoted in the solution array red.
	 * 
	 * @param image The image to overlay the solution onto
	 * @param solution An array of coorinates in the form { [row, column], ...}
	 * @return The Image with the solution overlayed
	 */
	public static BufferedImage overlaySolutionOntoImage(BufferedImage image, int[][] solution){
		//For each coordinate in the solution paint the corresponding pixel red
		BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		for(int x = 0; x < image.getWidth(); x++)
			for(int y = 0; y < image.getHeight(); y++)
				img.setRGB(x, y, image.getRGB(x, y));
		for(int[] coord : solution)
			img.setRGB(coord[1], coord[0], Color.RED.getRGB());
		//Return the image
		return img;
	}
}
