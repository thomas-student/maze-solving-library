package maze.impl;

/**
 * An extension of the Boolean Maze Implementation where the distance
 * between spaces is calculated based on the Diagonal Distance Formula
 * 
 * @author Thomas Johnston
 *
 */
public class DiagonalBooleanMazeImpl extends BooleanMazeImpl {

	public static double DIAGONAL_COST = Math.sqrt(2.0);
	
	/**
	 * The default constructor, randomly generates a maze based on the Maze Constants
	 */
	public DiagonalBooleanMazeImpl() {
		super();
	}
	
	/**
	 * A constructor that allows for specific mazes to be built
	 *  
	 * @param spaces The 2D boolean array signifying the validity of the spaces
	 */
	public DiagonalBooleanMazeImpl(boolean[][] spaces) {
		super(spaces);
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getDistanceBetweenSpaces(int, int, int, int)
	 * 
	 * Returns the distance between two spaces using the Manhattan distance formula
	 * 
	 */
	@Override
	public double getDistanceBetweenSpaces(int x1, int y1, int x2, int y2) {
		return DIAGONAL_COST * Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
	}	
}
