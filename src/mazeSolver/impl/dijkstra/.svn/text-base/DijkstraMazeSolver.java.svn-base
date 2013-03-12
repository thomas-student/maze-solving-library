package mazeSolver.impl.dijkstra;

import java.util.PriorityQueue;

import maze.Maze;
import mazeSolver.impl.pqueue.MazeNode;
import mazeSolver.impl.pqueue.PQueueMazeSolver;

/**
 * Solves a Maze using the Dijkstra algorithm
 * 
 * @author Thomas Johnston
 */
public class DijkstraMazeSolver extends PQueueMazeSolver {

	/**
	 * Default constructor for the Dijkstra Maze Solver
	 * @param maze The maze this is to solve
	 */
	public DijkstraMazeSolver() {
		super();
	}

	@Override
	protected void initializeQueue() {
		notDone = new PriorityQueue<MazeNode>();
		notDone.add(new DijkstraMazeNode(maze.getStartSpot(), maze));
	}
}