package fileIOTools;

import java.io.File;
import java.io.PrintWriter;

import maze.Maze;

/**
 * A class that enables the printing of Mazes and solutions into plaintext files for debugging and
 * basic graphic representation.
 * 
 * @author Thomas Johnston
 */
public class PlaintextFileIOService {

	public static final char WALKABLE_SPACE = ' ';
	public static final char NON_WALKABLE_SPACE = 'X';
	public static final char SOLUTION_SPACE = 'O';
	
	/**
	 * Prints a maze to file representing walkable and non-walkable spaces as their corresponding 
	 * character constants.
	 * 
	 * @param maze The maze to be printed.
	 * @param fname The file to print to.
	 */
	public static void printMazeToFile(Maze maze, String fname){
		try{
			//Declare and initialize the writer
			PrintWriter writer = new PrintWriter(new File(fname));
			//Cycle through the maze and print to file based on the validity of the space
			for(int r = 0; r < maze.getHeight(); r++)
				{
				for(int c = 0; c < maze.getWidth(); c++)
					if(maze.isValid(r, c))
						writer.print(WALKABLE_SPACE);
					else
						writer.print(NON_WALKABLE_SPACE);
				//End of row, move to next line
				writer.println();
				}
			//Close the writer
			writer.close();
		}
		//Catch and print all exceptions
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Prints a maze and solution to file
	 * 
	 * @param maze The maze to be printed.
	 * @param fname The file to print to.
	 * @param solution The solution to be printed
	 */
	public static void printMazeSolutionToFile(Maze maze, String fname, int[][] solution){
		try{
		//Declare and initialize the writer
		PrintWriter writer = new PrintWriter(new File(fname));
		//Cycle through the maze and print to file based on the validity of the space
		for(int r = 0; r < maze.getHeight(); r++)
			{
			for(int c = 0; c < maze.getWidth(); c++)
				{
				boolean solutionSpace = false;
				//If a solution space print the solution space character
				for(int[] coord : solution)
					if(coord[0] == r && coord[1] == c)
						{
						writer.print(SOLUTION_SPACE);
						solutionSpace = true;
						}
				//If not a solution space print a WALKABLE_SPACE or NON_WALKABLE_SPACE if (not) valid
				if(!solutionSpace)
					{
					if(maze.isValid(r, c))
						writer.print(WALKABLE_SPACE);
					else
					writer.print(NON_WALKABLE_SPACE);
					}
				}
			//End of line
			writer.println();
			}
		//Writer closed
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}