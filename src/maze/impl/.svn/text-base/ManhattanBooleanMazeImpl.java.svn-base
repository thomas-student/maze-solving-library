package maze.impl;


/**
 * An extension of the Boolean Maze Implementation where the distance
 * between spaces is calculated based on the Manhattan Distance Formula
 * 
 * @author Thomas Johnston
 *
 */
public class ManhattanBooleanMazeImpl extends BooleanMazeImpl {
	
	/**
	 * The default constructor, randomly generates a maze based on the Maze Constants
	 */
	public ManhattanBooleanMazeImpl() {
		super();
	}
	
	/**
	 * A constructor that allows for specific mazes to be built
	 *  
	 * @param spaces The 2D boolean array signifying the validity of the spaces
	 */
	public ManhattanBooleanMazeImpl(boolean[][] spaces) {
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
		if(Math.abs((double)x1-(double)x2) == 1 && Math.abs((double)y1-(double)y2)==1)
			return Math.sqrt(2.0);
		return (Math.abs((double)x1-(double)x2) + Math.abs((double)y1-(double)y2));
	}
	
}