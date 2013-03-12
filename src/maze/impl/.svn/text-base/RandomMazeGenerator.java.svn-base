package maze.impl;

import java.util.Random;

import maze.Maze;


public class RandomMazeGenerator {

	/**
	 * 
	 * Generates and fills the a 2D boolean array with pseudo-random values, gets the "randomness" by
	 * generating a random engine based on a hash of the current time in milliseconds
	 * 
	 * @param height The height of the resulting boolean array
	 * @param width The width of the resulting boolean array
	 * @return A 2D pseudo-random boolean array
	 */
	public static boolean[][] generateBooleanArray(int height, int width){
		//Initialize the 2D array and the RandomEngine
		boolean[][] spaces = new boolean[height][width];
		Random randomEngine = new Random(new Long(System.currentTimeMillis()).hashCode());
		
		//Randomly fill the maze with each space having a MAZE_WALL_PERCENTAGE chance of being invalid
		for(int r = 0; r < spaces.length; r++)
			for(int c = 0; c < spaces[0].length; c++)
				if(randomEngine.nextDouble() < Maze.MAZE_WALL_PERCENTAGE)
					spaces[r][c] = false;
				else
					spaces[r][c] = true;
		
		//Set the start and end points to valid
		spaces[0][0] = true;
		spaces[height-1][width-1] = true;

		//Return the array
		return spaces;
	}
}
