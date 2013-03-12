package mazeSolver.impl.aStar;

import java.util.PriorityQueue;

import maze.Maze;
import mazeSolver.impl.pqueue.MazeNode;
import mazeSolver.impl.pqueue.PQueueMazeSolver;


/**
 * Solves a Maze using the A* algorithm, a best-first PQueue based
 * algorithm
 * 
 * @author Thomas Johnston
 */
public class AStarMazeSolver extends PQueueMazeSolver {


	/**
	 * Default constructor for the A* Maze Solver
	 * 
	 * @param maze The maze this is to solve
	 */
	public AStarMazeSolver() {
		super();
	}

	@Override
	protected void initializeQueue() {
		notDone = new PriorityQueue<MazeNode>();
		notDone.add(new AStarMazeNode(maze.getStartSpot(), maze));
	}
}