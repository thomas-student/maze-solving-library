package mvc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import maze.impl.DiagonalBooleanMazeImpl;
import maze.impl.EuclideanBooleanMazeImpl;
import maze.impl.ManhattanBooleanMazeImpl;
import mazeSolver.impl.aStar.AStarMazeSolver;
import mazeSolver.impl.dijkstra.DijkstraMazeSolver;
import mvc.MazeSolverModel;
import mvc.View;

class GUIView implements View{
	
	//The Heuristics and pathfinding algorithm choices
	private String[] HEURISTICS = {"", "Manhattan", "Euclidean", "Diagonal"};
	private String[] PATHFINDING_ALGORITHMS = {"", "Dijkstra's", "A*"};
	
	//The Swing elements
	protected JComboBox heuristicsComboBox;
	protected JComboBox algorithmsComboBox;
	private JLabel heuristicsLabel;
	private JLabel algorithmsLabel;
	private JButton solveableButton;
	private JButton solveButton;
	private JButton inputGraphButton;
	private JButton outputGraphButton;
	private GUIControl applet;
	private MazeSolverModel model;
	private MazePanel mazePanel;
	
	
	/**
	 * The constructor for the View Component of the GUI MVC Architecture
	 * 
	 * @param control The Control Applet
	 * @param model The Model
	 */
	public GUIView(GUIControl control, MazeSolverModel model) {
		//Set the model and control references
		this.model = model;
		this.applet = control;
		
		//Declare the control panel (which holds the control elements
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
		//Declare the Maze Panel (Displays the current state of the model
		mazePanel = new MazePanel(model);
	
		//Instantiate the Swing Elements and include them
		heuristicsLabel = new JLabel("Heuristic:");
		addToControlPanel(heuristicsLabel, controlPanel);
		heuristicsComboBox = new JComboBox(HEURISTICS);
		addToControlPanel(heuristicsComboBox, controlPanel);
		algorithmsLabel = new JLabel("Pathfinding algorithm:");
		addToControlPanel(algorithmsLabel, controlPanel);
		algorithmsComboBox = new JComboBox(PATHFINDING_ALGORITHMS);
		addToControlPanel(algorithmsComboBox, controlPanel);
		solveableButton = new JButton("Is Solvable");
		addToControlPanel(solveableButton, controlPanel);
		solveButton = new JButton("Solve");
		addToControlPanel(solveButton, controlPanel);
		inputGraphButton = new JButton("Input graph from file");
		addToControlPanel(inputGraphButton, controlPanel);
		outputGraphButton = new JButton("Save graph to file");
		addToControlPanel(outputGraphButton, controlPanel);
		
		//Set the Alignment of the control panel
		controlPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		controlPanel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		controlPanel.setMaximumSize(new Dimension(50, 10));
		
		//Add the components to the Applet Content Pane
		control.getContentPane().setLayout(new BorderLayout());
		control.getContentPane().add(controlPanel, BorderLayout.WEST);
		control.getContentPane().add(mazePanel);
	    control.setSize((int) (control.getContentPane().getPreferredSize().getWidth()*(1.05)), (int) (control.getContentPane().getPreferredSize().getHeight()*1.05));
	} 

	private void addToControlPanel(JComponent component, JPanel panel){
		component.setAlignmentX(Component.CENTER_ALIGNMENT);
		component.setMaximumSize(component.getPreferredSize());
		panel.add(component);
		panel.add(Box.createRigidArea(new Dimension(5,5)));
	}
	
	/**
	 * Adds a listener to the input file button
	 * @param a The action Listener
	 */
	public void addInputFileListener(ActionListener a){
		inputGraphButton.addActionListener(a);
	}

	/**
	 * @return The JApplet associated with the view
	 */
	public JApplet getApplet() {
		return applet;
	}
	
	/* (non-Javadoc)
	 * @see mvc.View#notifyOfChange()
	 */
	public void notifyOfChange() {
		//Update the heuristics
		if(model.getMaze() == null)
			heuristicsComboBox.setSelectedIndex(0);
		else if(model.getMaze().getClass() == (DiagonalBooleanMazeImpl.class) && heuristicsComboBox.getSelectedIndex() != 3)
			heuristicsComboBox.setSelectedIndex(3);
		else if(model.getMaze().getClass() == (EuclideanBooleanMazeImpl.class)  && heuristicsComboBox.getSelectedIndex() != 2)
			heuristicsComboBox.setSelectedIndex(2);
		else if(model.getMaze().getClass() == (ManhattanBooleanMazeImpl.class)  && heuristicsComboBox.getSelectedIndex() != 1)
			heuristicsComboBox.setSelectedIndex(1);
		
		//Update the solver
		if(model.getSolver() == null)
			algorithmsComboBox.setSelectedIndex(0);
		else if(model.getMaze().getClass() == (DijkstraMazeSolver.class) && algorithmsComboBox.getSelectedIndex() != 1)
			algorithmsComboBox.setSelectedIndex(1);
		else if(model.getMaze().getClass() == (AStarMazeSolver.class) && algorithmsComboBox.getSelectedIndex() != 2)
			algorithmsComboBox.setSelectedIndex(2);
	}

	public void addSolveButtonListener(ActionListener actionListener) {
		solveButton.addActionListener(actionListener);
	}

	public void addChangeSolverListener(ActionListener actionListener) {
		algorithmsComboBox.addActionListener(actionListener);
	}

	public void addChangeHeuristicListener(ActionListener actionListener) {
		heuristicsComboBox.addActionListener(actionListener);
	}

	public void addSolveableButtonListener(ActionListener actionListener) {
		solveableButton.addActionListener(actionListener);
	}

	public void addOutputFileListener(ActionListener actionListener) {
		outputGraphButton.addActionListener(actionListener);
	}
}