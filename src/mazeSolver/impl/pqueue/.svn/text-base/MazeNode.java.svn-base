package mazeSolver.impl.pqueue;

import java.util.Stack;

import maze.Maze;

/**
 * A comparable MazeNode for use with the PQueue algorithms
 * 
 * @author Thomas Johnston
 */
@SuppressWarnings("rawtypes")
public abstract class MazeNode implements Comparable{
	
	protected int[] coordinate;
	protected double hValue;
	protected Maze maze;
	protected MazeNode cameFrom;
	
	/**
	 * Instantiates this instance, setting cameFrom to null
	 * 
	 * @param coord The coordinate
	 * @param maze The Maze
	 */
	public MazeNode(int[] coord, Maze maze){
		this.coordinate = coord;
		this.maze = maze;
		this.hValue = 1;
		this.cameFrom = null;
	}
	
	/**
	 * Instantiates this instance, setting cameFrom to null
	 * 
	 * @param coord The coordinate
	 * @param maze The maze
	 * @param from The last node in the chain
	 */
	public MazeNode(int[] coord, Maze maze, MazeNode from) {
		this.coordinate = coord;
		this.maze = maze;
		this.cameFrom = from;
		this.hValue = (from.gethValue())+maze.getDistanceBetweenSpaces(coord[1], coord[0], from.getCoordinate()[1], from.getCoordinate()[0]);
	}

	/**
	 * @return the hValue
	 */
	public double gethValue() {
		return hValue;
	}

	/**
	 * @param hValue the hValue to set
	 */
	public void sethValue(double hValue) {
		this.hValue = hValue;
	}

	/**
	 * @return The coordinate
	 */
	public int[] getCoordinate(){
		return coordinate;
	}
	
	/**
	 * @return the cameFrom
	 */
	public MazeNode getCameFrom() {
		return cameFrom;
	}

	/**
	 * @param cameFrom the cameFrom to set
	 */
	public void setCameFrom(MazeNode cameFrom) {
		this.cameFrom = cameFrom;
	}

	/**
	 * @return The list of Nodes's coordinates that it took to get to this node
	 */
	public int[][] getList(){
		Stack<int[]> path = walkBackRecursiveHelper(new Stack<int[]>());
		int[][] retVal = new int[path.size()][2];
		for(int i = 0; i < retVal.length; i++)
			retVal[i] = path.pop();
		return retVal;
	}
	
	/**
	 * The helper method for getList()
	 * 
	 * @param in, the current path
	 * @return The full path to this node
	 */
	private Stack<int[]> walkBackRecursiveHelper(Stack<int[]> in){
		in.add(coordinate);
		if(cameFrom == null)
			return in;
		else
			return cameFrom.walkBackRecursiveHelper(in);
	}
	
	@Override
	public abstract int compareTo(Object arg0);	

	public abstract MazeNode[] addSpots(int[][] spots);

}