package mvc.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import fileIOTools.ImageFileIOService;

import maze.Maze;
import mvc.MazeSolverModel;

public class MazePanel extends JPanel {

	//The default constants
	private final String NO_LOADED_GRAPH_STRING = "No Loaded Graph";
	private final Dimension DEFAULT_SIZE = new Dimension(300, 300);
		
	//A reference to the model
	private MazeSolverModel model;
		
	/**
	 * The contructor for the Maze Panel
	 * 
	 * @param model The model
	 */
	public MazePanel(MazeSolverModel model){
		super();
		this.model = model;
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		super.paint(g);
		//If no image then print a boolean based visual of the maze
		if(model.getSrcImage() == null){
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(1, 1, (int) DEFAULT_SIZE.getWidth()-1, (int) DEFAULT_SIZE.getHeight()-1);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, (int)DEFAULT_SIZE.getWidth(), (int)DEFAULT_SIZE.getHeight());
			g.drawString(NO_LOADED_GRAPH_STRING, (int)DEFAULT_SIZE.getWidth()/2-45, (int) DEFAULT_SIZE.getHeight()/2);
		}
		//Otherwise print the iamge and overlay the solution if it exists
		else{
			g.drawImage(model.getSrcImage(), 0, 0, getParent());
			g.setColor(Color.red);
			if(model.getSolutions() != null)
			{
				for(int[] coord : model.getSolutions())
					g.drawLine(coord[1], coord[0], coord[1], coord[0]);
			}
		}
		//Repaint so it is constantly up to date
		repaint();
	}	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize(){
		if(model.getMaze() == null)
			return DEFAULT_SIZE;
		else
			return new Dimension(model.getMaze().getWidth(),model.getMaze().getHeight());
	}
	
}
