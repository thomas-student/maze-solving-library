package mazeSolver.impl.aStar;

import maze.Maze;
import mazeSolver.impl.pqueue.MazeNode;

/**
 * An extension of MazeNode implemented for the AStarMazeSolver
 * 
 * @author Thomas Johnston
 *
 */
public class AStarMazeNode extends MazeNode {
	
	/**
	 * @param coord The coordinate this node represents
	 * @param maze The maze that this node lives on
	 */
	public AStarMazeNode(int[] coord, Maze maze) {
		super(coord, maze);
	}
	
	/**
	 * @param coord The coordinate this node represents
	 * @param maze The maze that this node lives on
	 * @param from The node this node came from
	 */
	public AStarMazeNode(int[] coord, Maze maze, MazeNode from) {
		super(coord, maze, from);
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.mazeSolver.impl.pqueue.MazeNode#compareTo(java.lang.Object)
	 *
	 * An A* implementation of the compareTo function that calculates the F-value
	 */
	public int compareTo(Object arg0) {
		//Cast arg0 to a AStarMazeNode
		AStarMazeNode pathB = (AStarMazeNode)arg0;
		if(getFValue() == pathB.getFValue())
			return 0;
		else
			if (getFValue() > pathB.getFValue())
				return 1;
			else
				return -1;
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.mazeSolver.impl.pqueue.MazeNode#addSpots(int[][])
	 *
	 * Instantiates some new MazeNodes to represent the spots around this one
	 */
	public MazeNode[] addSpots(int[][] spots){
		MazeNode[] nodes = new MazeNode[spots.length];
		for(int i = 0; i < nodes.length; i++)
			nodes[i] = new AStarMazeNode(spots[i], maze, this);
		return nodes;
	}

	/**
	 * Calculates the F-value
	 * 
	 * @return The F-Value
	 */
	public double getFValue(){
		double f = 0;
		//Add the hValue to the F-value
		f += this.hValue;
		//Add the distance between this spot and the end
		f += maze.getDistanceBetweenSpaces(maze.getEndSpot()[1], maze.getEndSpot()[0], coordinate[1], coordinate[0]);
		return f;
	}
}