package mvc.cmd;

import java.io.File;
import java.util.Scanner;

import maze.impl.DiagonalBooleanMazeImpl;
import maze.impl.EuclideanBooleanMazeImpl;
import maze.impl.ManhattanBooleanMazeImpl;
import mazeSolver.impl.aStar.AStarMazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;
import mvc.MazeSolverController;
import mvc.MazeSolverModel;
import mvc.View;

/**
 * The view for a command prompt based Model-Controller-View
 * 
 * @author Thomas Johnston
 */
public class MazeSolverCMDView implements Runnable, View{

	//References to the model and controller
	private MazeSolverModel model;
	private MazeSolverController controller;
	
	//Some String array constants for the menu's
	private static final String[] MAIN_CHOICES = {"Main Menu", "Input New Maze", "Set Heuristic",
						"Set Pathfinding Algorithm", "Solve Maze", "Output to bitmap", "Quit"};
	private static final String[] HEURISTIC_CHOICES = {"Set Heuristic", "Euclidean",
																			"Manhattan", "Diagonal"};
	private static final String[] ALG_CHOICES = {"Set Pathfinding Algorithm", "Dijkstra", "AStar"};
	
	/**
	 * The main constructor for a CMD MCV
	 */
	public MazeSolverCMDView(){
		model = new MazeSolverModel();
		controller = new MazeSolverController();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 
	 * Starts the view
	 */
	@Override
	public void run() {
		while(true){
			printStatus();
			int choice = makeChoice(MAIN_CHOICES);
			switch (choice){
			case 0: inputNewMaze();
					break;
			case 1: setHeuristic();
					break;
			case 2: setPathfindingAlg();
					break;
			case 3: solveMaze();
					break;
			case 4: printMazeToFile();
					break;
			case 5: System.out.println("Bye!");
					return;
			}
		}
	}
	
	/**
	 * Prints the maze (and solution if existant) to file.
	 */
	private void printMazeToFile() {
		//First ensure the maze and sover are instantiated
		if(model.getMaze() == null)
		{
			System.out.println("Maze not loaded yet, load maze before attempting to print maze.");
			return;
		}
		if(model.getSolver() == null)
		{
			System.out.println("Solver not initialized yet, in itialize sovler before attempting to print maze.");
			return;
		}
		
		//Ask for filename
		System.out.print("Enter new file name (ending in .bmp): ");
		Scanner reader = new Scanner(System.in);
		String fname = reader.nextLine();
		
		//Ask the controller to print to file
		boolean success = controller.printMazeToFile(model.getMaze(), model.getSolutions(), fname);
		
		//Notify the user if it was successful
		if(success)
			System.out.println("Success!");
		else
			System.out.println("Fail.");
	}

	/**
	 * Queries the user for a filename and then passes the business logic to the Controller
	 */
	private void inputNewMaze() {
		//Prompt for a filename
		System.out.print("Enter the image filename: ");
		Scanner reader = new Scanner(System.in);
		//Pass work to the Controller and notify user of success/failure
		if(controller.inputImage(new File(reader.nextLine())))
			System.out.println("Input Successfully!");
		else
			System.out.println("Failed.");
	}

	/**
	 * Queries the user for a heuristic and then passes the business logic to the Controller
	 */
	private void setHeuristic() {
		//Query user for the heuristic
		if(model.getMaze() == null)
			{
			System.out.println("Maze not loaded yet, load maze before changing heuristic.");
			return;
			}
		int choice = makeChoice(HEURISTIC_CHOICES);
		//Take choice and pass corresponding work to the controller
		boolean worked = false;
		switch (choice){
		case 0: worked = controller.changeHeuristic(MazeSolverController.EUCLIDEAN_HEURISTIC);
				break;
		case 1: worked = controller.changeHeuristic(MazeSolverController.MANHATTAN_HEURISTIC);
				break;
		case 2: worked = controller.changeHeuristic(MazeSolverController.DIAGONAL_HEURISTIC);
				break;	
		}
		//Notify user of success/failure
		if(worked)
			System.out.println("Success!");
		else
			System.out.println("Failed.");
	}

	/**
	 * Queries the user for a Pathfinding alg and then passes the business logic to the Controller
	 */
	private void setPathfindingAlg() {
		//Query user for Pathfinding algorithm
		if(model.getMaze() == null)
		{
			System.out.println("Maze not loaded yet, load maze before changing heuristic.");
			return;
		}
		int choice = makeChoice(ALG_CHOICES);
		boolean worked = false;
		//Take choice and pass corresponding work to the controller
		switch (choice){
		case 0: worked = controller.changeSolver(MazeSolverController.DIJKSTRA_SOLVER);
				break;
		case 1: worked = controller.changeSolver(MazeSolverController.ASTAR_SOLVER);
				break;
		}
		//Notify user of success/failure
		if(worked)
			System.out.println("Success!");
		else
			System.out.println("Fail.");
	}

	/**
	 * Solves maze if maze and sovler are instantiated
	 */
	private void solveMaze() {
		//If maze or solver are not instantiated then notify user and do not attempt to solve
		if(model.getMaze() == null)
		{
			System.out.println("Maze not loaded yet, load maze before attempting to solve maze.");
			return;
		}
		if(model.getSolver() == null)
		{
			System.out.println("Solver not initialized yet, in itialize sovler before attempting to solve maze.");
			return;
		}
		//Solve maze
		controller.solveMaze();
		//Notify user of completion
		System.out.println("Finished!");
	}

	/**
	 * Takes in an array of Strings and presents them to the user as a menu
	 * 
	 * @param options The options for the user to choose from (the value in index 0 is the menu name)
	 * @return The integer value of the choice the user makes
	 */
	private int makeChoice(String[] options){
		//Print the menu name
		System.out.println(options[0]);
		//Print the options
		for(int i = 0; i < options.length-1; i++)
			System.out.println(i+") "+options[i+1]);
		int input = -1;
		//Ask the user for a valid option until one is provided
		Scanner reader = new Scanner(System.in);
		while(input < 0 || input >= options.length)
			{
			System.out.print("Enter a valid number: ");
			input = reader.nextInt();
			}
		//Return the decision
		return input;
	}
	
	/**
	 * Prints the current status of the view
	 */
	private void printStatus(){
		printMaze();
		printHeuristic();
		printSolver();
		printSolution();
	}
	
	/**
	 * Prints the solutions status
	 */
	private void printSolution() {
		//If solution is null then print no solution
		System.out.print("Solution:");
		if(model.getSolutions() == null)
			System.out.println(" No solution");
		//If solution is an empty set print that the solution has not been attempted yet
		else if(model.getSolutions().length == 0)
			System.out.println(" Not attempted yet");
		//Otherwise print the first 5 coordinate pairs of the solution
		else{
			System.out.print("[");
			for(int i = 0; i < Math.min(model.getSolutions().length, 5); i++)
				System.out.print(" ("+model.getSolutions()[i][0]+", "+model.getSolutions()[i][1]+") ");
			if(model.getSolutions().length > 5)
				System.out.print("...] (length: "+model.getSolutions().length+")");
			else
				System.out.println("]");
			}
	}

	/**
	 * Prints the current status and type of the solution
	 */
	private void printSolver() {
		System.out.print("Solver: ");
		//If the solver is null print that it is not instantiated
		if(model.getSolver() == null)
			System.out.println("Not instantiated");
		//Otherwise print the maze solving algorithm
		else
			if(model.getSolver().getClass() == DijkstraMazeSolver.class)
				System.out.println("Dijkstra");
			else if(model.getSolver().getClass() == AStarMazeSolver.class)
				System.out.println("A*");
	}

	/**
	 * Prints the status of the maze (loaded or not loaded)
	 */
	private void printMaze(){
		System.out.print("Maze: ");
		if(model.getMaze() == null)
			System.out.println("not loaded");
		else
			System.out.println("loaded");
	}
	
	/**
	 * Prints the heuristic type
	 */
	private void printHeuristic(){
		System.out.print("Heuristic: ");
		//if the maze is null then print n/a for the heuristic
		if(model.getMaze() == null)
			System.out.println("n/a");
		//Otherwise print the heuristic associated with the maze
		else if(model.getMaze().getClass() == (DiagonalBooleanMazeImpl.class))
			System.out.println("Diagonal");
		else if(model.getMaze().getClass() == (EuclideanBooleanMazeImpl.class))
			System.out.println("Euclidean");
		else if(model.getMaze().getClass() == (ManhattanBooleanMazeImpl.class))
			System.out.println("Manhattan");
		else
			System.out.println("n/a");
	}

	public void notifyOfChange() {
		
	}
	
}