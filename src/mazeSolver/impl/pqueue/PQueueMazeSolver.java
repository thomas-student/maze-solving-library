package mazeSolver.impl.pqueue;

import java.util.HashMap;
import java.util.PriorityQueue;

import maze.Maze;
import mazeSolver.MazeSolver;

/**
 * A priority queue implementation that allows for the use of 
 * different algorithm
 * 
 * @author Thomas Johnston
 */
public abstract class PQueueMazeSolver implements MazeSolver {

	//The Priority Queue that holds the open list
	protected PriorityQueue<MazeNode> notDone;
	//The Array List that holds the closed list, when scaling up use a hashmap or something more efficient
	HashMap<String, Boolean> done;
	protected Maze maze;
	
	/**
	 * Initializes the PQueue Maze solver
	 * 
	 * @param maze The Maze
	 */
	public PQueueMazeSolver(){
	}
	
	protected abstract void initializeQueue();
	
	/* (non-Javadoc)
	 * @see cs242.johnst26.mazeSolver.MazeSolver#solveMaze()
	 * 
	 * Solves the maze
	 */
	public int[][] solveMaze(Maze maze){
		this.maze = maze;
		done = new HashMap<String, Boolean>();
		initializeQueue();

		initializeQueue();
		MazeNode finished = null; //The finished value
		//Iterate while notDone is not zero
		while(notDone.size() > 0)
		{
			//Retrieve head node
			MazeNode head = notDone.poll();
			//If this head is the last spot in the maze it finishes
			if(head.getCoordinate()[0] == maze.getEndSpot()[0] && head.getCoordinate()[1] == maze.getEndSpot()[1])
				{
					finished = head;
					break;
				}
			//Add head node to closed list
			done.put(head.getCoordinate()[0]+","+head.getCoordinate()[1], true);
			//Handle the head notDone adjacent notDone
			handleAvailables(head);
		}
		if(finished != null)
			return finished.getList();
		else
			return null;
	}
	
	/**
	 * Handles the available notDone around the given node
	 * 
	 * @param p The Node in question
	 */
	private void handleAvailables(MazeNode node){
		//Get available spaces
		int[][] availables = maze.getValidAdjacentSpaces(node.getCoordinate()[0], node.getCoordinate()[1]);
		for(MazeNode nodeTemp : node.addSpots(availables))
		{
			boolean add = true;	
			//If node is in closed list do not add
			if(done.get(nodeTemp.getCoordinate()[0]+","+nodeTemp.getCoordinate()[1]) != null)
				continue;
			//If node is in open list and it has a lower h value than its counterpart then replace that node in the open list
			for(MazeNode m : notDone)
				if(m.getCoordinate()[0] == nodeTemp.getCoordinate()[0] && m.getCoordinate()[1] == nodeTemp.getCoordinate()[1])
					{
					add = false;
					if(m.gethValue() > nodeTemp.gethValue())
						{
						notDone.remove(m);
						notDone.add(nodeTemp);
						break;
						}
					}	 
			
			//if should add, then add to the open list
			if(add)
				notDone.add(nodeTemp);
		}
	}
}