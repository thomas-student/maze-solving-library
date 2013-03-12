package mazeSolver.impl.dijkstra;

import maze.Maze;
import mazeSolver.impl.pqueue.MazeNode;

/**
 * An extension of MazeNode implemented for the DijkstraMazeSolver
 * 
 * @author Thomas Johnston
 */
public class DijkstraMazeNode extends MazeNode {
	
	/**
	 * @param coord The coordinate this node represents
	 * @param maze The maze that this node lives on
	 */
	public DijkstraMazeNode(int[] coord, Maze maze) {
		super(coord, maze);
	}
	
	/**
	 * @param coord The coordinate this node represents
	 * @param maze The maze that this node lives on
	 * @param from The node this node came from
	 */
	public DijkstraMazeNode(int[] coord, Maze maze, MazeNode from) {
		super(coord, maze, from);
	}

	/* (non-Javadoc)
	 * @see cs242.johnst26.mazeSolver.impl.pqueue.MazeNode#compareTo(java.lang.Object)
	 *
	 * An Dijkstra implementation of the compareTo function that calculates the H-value
	 */
	public int compareTo(Object arg0) {
		//Cast arg0 to a DijkstraMazeNode
		DijkstraMazeNode pathB = (DijkstraMazeNode)arg0;
		if(gethValue() == pathB.gethValue())
			return 0;
		else
			if (gethValue() > pathB.gethValue())
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
			nodes[i] = new DijkstraMazeNode(spots[i], maze, this);
		return nodes;
	}
}