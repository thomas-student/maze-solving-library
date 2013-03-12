package maze.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * An extension of the Boolean Maze Implementation where the distance
 * between spaces is calculated based on the Euclidean Distance Formula
 * 
 * @author Thomas Johnston
 *
 */
public class EuclideanBooleanMazeImpl extends BooleanMazeImpl {

	/**
	 * The default constructor, randomly generates a maze based on the Maze Constants
	 */
	public EuclideanBooleanMazeImpl() {
		super();
	}
	
	/**
	 * A constructor that allows for specific mazes to be built
	 *  
	 * @param spaces The 2D boolean array signifying the validity of the spaces
	 */
	public EuclideanBooleanMazeImpl(boolean[][] spaces) {
		super(spaces);
	}

	public EuclideanBooleanMazeImpl(BufferedImage srcImage) {
		super(srcImage);
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.maze.Maze#getDistanceBetweenSpaces(int, int, int, int)
	 * 
	 * Returns the distance between two spaces using the Manhattan distance formula
	 * 
	 */
	@Override
	public double getDistanceBetweenSpaces(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}	
}