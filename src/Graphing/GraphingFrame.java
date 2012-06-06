/**
 * 
 */
package Graphing;

import java.awt.*;

import javax.swing.*;

/**
 * @author Palmer
 *
 */
public class GraphingFrame extends JFrame {
	private int frame_width = 600;
	private int frame_height = 600;
	
	private GraphingGrid grid;
	
	protected Container container;
	
	public GraphingFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Graphing Points");
		
		this.setSize(frame_width, frame_height);
		
		grid = new GraphingGrid(frame_width, frame_height);
		container = this.getContentPane();
		container.add(grid);
	}

	public void graphPoints(Point[] points) {
		// TODO Auto-generated method stub
		grid.drawPoints(points, grid.getGraphics());
	}

	public void drawPoint(int i, int j) {
		// TODO Auto-generated method stub
		grid.drawPoint(i, j);
		
	}

}
