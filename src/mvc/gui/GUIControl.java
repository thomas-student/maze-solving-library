package mvc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JApplet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import mvc.MazeSolverController;
import mvc.MazeSolverModel;
import mvc.cmd.MazeSolverCMDView;

/**
 * The Control aspect of the GUI MVC Architecture
 * 
 * @author Thomas Johnston
 */
public class GUIControl extends MazeSolverController {
	  
	  /* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		//Instantialize the model and view and set the applet's name
	    model = new MazeSolverModel();
	    view = new GUIView(this, model);
	    this.setName("Maze Solver Library Interactive");
	    
	    //The listener that activates the File Chooser to load mazes from file
	    ((GUIView) view).addInputFileListener(new ActionListener(){
		    public void actionPerformed(ActionEvent event) {
		    	//Let the user specify the file to load
		    	JFileChooser fc = new JFileChooser();
		    	int returnVal = fc.showOpenDialog(((GUIView) view).getApplet());
		    	//Pass the file to the inputImage method to load the Maze and send it to the model.
		        if (returnVal == JFileChooser.APPROVE_OPTION)
		        	inputImage(fc.getSelectedFile());
		    }
	    });
	    
	    //The listener that activates the File Chooser to save mazes to file
	    ((GUIView) view).addOutputFileListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent event) {
	    		//Let the user specify the file to load
	    		JFileChooser fc = new JFileChooser();
		    	int returnVal = fc.showOpenDialog(((GUIView) view).getApplet());
		    	//Save the image to file by calling outputImage
		        if (returnVal == JFileChooser.APPROVE_OPTION)
		        	outputImage(fc.getSelectedFile());
		      }
		 });
	    
	    //Add the listener to wait for user to press "solve"
	    ((GUIView) view).addSolveButtonListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  solveMaze();
		   }
		});
	    
	    //Add the listener to wait for user to press "Is Solveable" and notify the user depending on the result
	    ((GUIView) view).addSolveableButtonListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  boolean solveable = isSolveable();
		    	  //Notify the user of whether the maze is solvable
		    	  if(solveable)
		    		  JOptionPane.showMessageDialog( ((GUIView)view).getApplet(), "Maze is solvable.");
		    	  else
		    		  JOptionPane.showMessageDialog( ((GUIView)view).getApplet(), "No solution is possible.");

		   }
		});
	    
	    //Add the listener to watch the heuristic combo box and update the model to the changes
	    ((GUIView) view).addChangeHeuristicListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  if( ((GUIView) view).heuristicsComboBox.getSelectedIndex() == 1)
		    		  changeHeuristic(MazeSolverController.MANHATTAN_HEURISTIC);
		    	  if( ((GUIView) view).heuristicsComboBox.getSelectedIndex() == 2)
		    		  changeHeuristic(MazeSolverController.EUCLIDEAN_HEURISTIC);
		    	  if( ((GUIView) view).heuristicsComboBox.getSelectedIndex() == 3)
		    		  changeHeuristic(MazeSolverController.DIAGONAL_HEURISTIC);
		    	  view.notifyOfChange();
		      }
		 });
	    
	    //Add the listener to watch the pathfinding algorithm combo box and update the model to the changes
	    ((GUIView) view).addChangeSolverListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event) {
		    	  if( ((GUIView) view).algorithmsComboBox.getSelectedIndex() == 1)
		    		  changeSolver(MazeSolverController.DIJKSTRA_SOLVER);
		    	  if( ((GUIView) view).algorithmsComboBox.getSelectedIndex() == 2)
		    		  changeSolver(MazeSolverController.ASTAR_SOLVER);
		    	  view.notifyOfChange();
		      }
		 });
	  } 
}