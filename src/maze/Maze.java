package maze;

import java.awt.image.BufferedImage;

/**
 * The Maze interface showcasing each of the required methods for a Maze implementation
 * 
 * @author Thomas Johnston
 */
public interface Maze {

	//The percentage of spaces that are walls when randomly generating the maze
	public static final double MAZE_WALL_PERCENTAGE = .15;

	//The default maze heights and widths
	public static final int DEFAULT_MAZE_HEIGHT = 100;
	public static final int DEFAULT_MAZE_WIDTH = 100;
	
	//The default start and end spots
	public static final int[] DEFAULT_START_SPOT = {0,0};
	public static final int[] DEFAULT_END_SPOT = {99,99};
	
	
	/**
	 * Returns the distance between two spaces
	 * 
	 * @param r The Row for the given space
	 * @param c The Column for the given space
	 * @return An array of coordinates
	 */
	public int[][] getValidAdjacentSpaces(int r, int c);
	
	/**
	 * Returns the boolean containing the validity of the space
	 * 
	 * @param r The Row for the given space
	 * @param c The Column for the given space
	 * @return The validity of the given space
	 */
	public boolean isValid(int r, int c);
	
	/**
	 * Returns the distance between two spaces on the maze
	 * 
	 * @param x1 The first coordinates x value
	 * @param y1 The first coordinates y value
	 * @param x2 The second coordinates x value
	 * @param y2 The second coordinates y value
	 * @return The distance
	 */
	public double getDistanceBetweenSpaces(int x1, int y1, int x2, int y2);
	
	/**
	 * Returns an image representation of the maze
	 * 
	 * @return An image representation based on the maze.
	 */
	public BufferedImage getImage();
	
	/**
	 * @return The width
	 */
	public int getWidth();
	
	/**
	 * @return The height
	 */
	public int getHeight();
	
	/**
	 * @return The Start Spot
	 */
	public int[] getStartSpot();
	
	
	/**
	 * @return The end spot
	 */
	public int[] getEndSpot();
	
	/**
	 * @return the spaces
	 */
	public boolean[][] getSpaces();
	
	/**
	 * @return the spaces
	 */
	public void resetMaze(boolean[][] spaces);

}
