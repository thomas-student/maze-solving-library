package maze.impl;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import fileIOTools.ImageFileIOService;

import maze.Maze;

/**
 * An abstract implementation of the Maze Interface. This is a Boolean implementation, in that the
 * spaces of the maze are stored as an 2D array of booleans containing whether or `not the space 
 * is valid or invalid (whether it is a wall or not). The distance between spaces is then left up
 * to the sub-class to implement, giving the option of "pluggable heuristics"
 * 
 * @author Thomas Johnston
 *
 */
public class BooleanMazeImpl implements Maze {

	private int mazeWidth;
	private int mazeHeight;
	private int[] startSpot;
	private int[] endSpot;
	private BufferedImage originalImage;
	private boolean[][] spaces;


	/**
	 * The default constructor, randomly generates a maze based on the Maze Constants
	 */
	public BooleanMazeImpl(){
		//Set height, width, startSpot, and endSpot to the default values
		this.mazeWidth = Maze.DEFAULT_MAZE_WIDTH;
		this.mazeHeight = Maze.DEFAULT_MAZE_HEIGHT;
		this.startSpot = Maze.DEFAULT_START_SPOT;
		this.endSpot = Maze.DEFAULT_END_SPOT;
		this.originalImage = null;
		//Instantiate the new maze to a random maze based on the default values
		this.spaces = RandomMazeGenerator.generateBooleanArray(mazeHeight, mazeWidth);
	}
	
	/**
	* A constructor that takes in a Buffered Image to parse into the maze
	 */
	public BooleanMazeImpl(BufferedImage image){
		//Set height, width, startSpot, and endSpot to the default values
		resetMaze(ImageFileIOService.getBooleanArray(image));
		this.originalImage = image;
	}
	
	/**
	 * A constructor that allows for specific mazes to be built
	 *  
	 * @param spaces The 2D boolean array signifying the validity of the spaces
	 */
	public BooleanMazeImpl(boolean[][] spaces){
		resetMaze(spaces);
		this.originalImage = null;
	}
	
	/**
	 * Resets the maze based on the 2D boolean array.
	 * 
	 * @param spaces The 2D boolean array
	 */
	public void resetMaze(boolean[][] spaces){
		this.spaces = spaces;
		this.mazeHeight = spaces.length;
		this.mazeWidth = spaces[0].length;
		this.startSpot = Maze.DEFAULT_START_SPOT;
		int[] endSpot = {mazeHeight-1, mazeWidth-1};
		this.endSpot = endSpot;
		validateStartAndEndSpots();
	}
	
	public BufferedImage getImage(){
		if(originalImage == null)
			return null;
		else
			return originalImage;
	}
	
	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getValidAdjacentSpaces(int, int)
	 * 
	 * Lists valid spaces adjacent to the given space
	 * 
	 */
	@Override
	public int[][] getValidAdjacentSpaces(int row, int col) {
		//Instantiate 2 Lists to hold the x and y values of the valid adjacent spaces
		LinkedList<int[]> spots = new LinkedList<int[]>();
		//For all 8 points around the given coordinate add to the lists the x's and y's for the valid spaces
		for(int r = row-1; r <= row+1; r++)
			for(int c = col-1; c <= col+1; c++)
				{
					if( (r!=row || c!=col) && isValid(r, c) )
					{
						int[] spot = {r, c};
						spots.add(spot);
					}
				}
		//Compile the valid spaces from arraylists into the return array
		int[][] validSpaces = new int[spots.size()][2];
		for(int i = 0; i < spots.size(); i++)
		{
			validSpaces[i]=spots.get(i);
		}		
		return validSpaces;
	}
	
	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getDistanceBetweenSpaces(int, int, int, int)
	 * 
	 * Returns the distance between two spaces using the Manhattan distance formula
	 * 
	 */
	@Override
	public double getDistanceBetweenSpaces(int x1, int y1, int x2, int y2){
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}
	
	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#isValid(int, int)
	 * 
	 * Returns the boolean containing the validity of the space
	 */
	public boolean isValid(int r, int c){		
		//If x or y are below zero or beyond the scope of the maze return false
		if(r < 0 || c < 0 || c >= mazeWidth || r >= mazeHeight)
			return false;
		//Otherwise return the value stored at the spot in the 2D boolean array
		return spaces[r][c];
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getWidth()
	 * 
	 * Returns the width
	 */
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return mazeWidth;
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getHeight()
	 * 
	 * Returns the height
	 */
	@Override
	public int getHeight() {
		return mazeHeight;
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getStartSpot()
	 */
	@Override
	public int[] getStartSpot() {
		return startSpot;
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getEndSpot()
	 */
	@Override
	public int[] getEndSpot() {
		return endSpot;
	}
	
	/**
	 * @return the spaces
	 */
	@Override
	public boolean[][] getSpaces() {
		return spaces;
	}
	
	/**
	 * Moves the start and end spots down the axis until they occupy valid spots.
	 */
	private void validateStartAndEndSpots() {
		
		while(isValid(startSpot[0], startSpot[1]) == false)
		{
			startSpot[0]++;
			if(startSpot[0] >= mazeHeight)
			{
				startSpot[0] = 0;
				break;
			}
		}
		
		while(isValid(startSpot[0], startSpot[1]) == false)
		{
			startSpot[1]++;
			if(startSpot[1] >= mazeWidth)
			{
				startSpot[1] = 0;
				break;
			}
		}
		
		while(isValid(endSpot[0], endSpot[1]) == false)
		{
			endSpot[0]--;
			if(endSpot[0] <= 0)
				break;
		}
		
		while(isValid(endSpot[0], endSpot[1]) == false)
		{
			endSpot[1]--;
			if(endSpot[1] <= 0)
				{
				endSpot[1] = getWidth()-1;
				break;
				}
		}		
	}
}
