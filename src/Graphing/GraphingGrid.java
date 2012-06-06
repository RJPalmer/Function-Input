/**
 * 
 */
package Graphing;

import java.awt.*;

import javax.swing.JPanel;

/**
 * @author Palmer
 *
 */
public class GraphingGrid extends JPanel
{
	private double xAxis;
	private int axisThickness;
	private double yAxis;
	private int gridHeight;
	private int gridWidth;
	private double xMin;
	private double xMax;
	private double xInterval;	
	private double yInterval;
	private Point screenCenter;
	private Point gridCenter;
	private Point[] gridPoints;
	private Point gridPoint;
	private int yMin;
	private int yMax;
	private int xDiff;
	private int yDiff;
	
	
	
	/*
	 * Constructor
	 */
	public GraphingGrid(int frame_width, int frame_height){
		this.setBackground(Color.WHITE);
		gridHeight = frame_height;
		gridWidth = frame_width;
		xAxis = gridWidth / 2;
		yAxis = gridHeight / 2;
		
		xInterval = 50;
		yInterval = 50;
		xMin = -10;
		xMax = 10;
		yMin = -10;
		yMax = 10;
		
		
		screenCenter = new Point();
		screenCenter.x = (int)xAxis;
		screenCenter.y = (int)yAxis;
		
		
		gridCenter = new Point(0,0);
		xDiff = screenCenter.x - gridCenter.x;
		yDiff = screenCenter.y - gridCenter.y;
	}

	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		adjust();
		drawAxis(g);
		drawTicks(g);
		drawFunctionPoints(g);
		
	}
	
	
	private void adjust() {
		// TODO Auto-generated method stub
		gridHeight = this.getHeight();
		gridWidth = this.getWidth();
		
		setxAxis(gridHeight / 2);
		setyAxis(gridWidth / 2);
		
		screenCenter.y = (int)getxAxis();
		screenCenter.x = (int)getyAxis();
		xDiff = screenCenter.x - gridCenter.x;
		yDiff = screenCenter.y - gridCenter.y;
	}


	private void drawFunctionPoints(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		Point startPoint = new Point();
		Point endPoint = new Point();
		if(this.gridPoints != null){
			
			startPoint.x = (int) (gridPoints[0].x * xInterval);
			if(gridPoints[0].y < 0){
				startPoint.y = (int) (Math.abs(gridPoints[0].y) * yInterval);
			}
			else{
				startPoint.y = gridPoints[0].y * -1; 
				startPoint.y *= yInterval;
			}
			startPoint.x += (xDiff);
			startPoint.y = Math.abs(startPoint.y += yDiff);
			
			
			//endPoint = gridPoints[i+1];
			endPoint.x = (int) (gridPoints[gridPoints.length - 1].x * xInterval);
			if(gridPoints[gridPoints.length - 1].y < 0){
				endPoint.y = (int) (Math.abs(gridPoints[gridPoints.length - 1].y) * yInterval);
			}
			else{
				endPoint.y = gridPoints[gridPoints.length - 1].y * -1;
				endPoint.y *= yInterval;
			}
			endPoint.x = endPoint.x += (xDiff);
			endPoint.y = endPoint.y += (yDiff);
			
			g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
			
		}
	}


	private void drawTicks(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		for(int i = screenCenter.y; i > 0; i-=yInterval){
			g2d.drawLine(screenCenter.x - 5, i, screenCenter.x  + 5, i);
		}
		for(int i = screenCenter.y; i < this.gridHeight; i+=yInterval){
			g2d.drawLine(screenCenter.x - 5, i, screenCenter.x  + 5, i);
		}
		
		for(int i = screenCenter.x; i > 0; i-=xInterval){
			g2d.drawLine(i, screenCenter.y - 5,  i, screenCenter.y  + 5);
		}
		for(int i = screenCenter.x; i < this.gridHeight; i+=xInterval){
			g2d.drawLine( i,screenCenter.y - 5,  i, screenCenter.y  + 5 );
		}
	}


	private void drawAxis(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(2F));
		g2d.drawLine(0, screenCenter.y, getGridWidth(), screenCenter.y);
		g2d.drawLine(screenCenter.x, 0, screenCenter.x, getGridHeight());
	}


	/**
	 * @param xAxis the xAxis to set
	 */
	protected void setxAxis(double xAxis) {
		this.xAxis = xAxis;
	}

	/**
	 * @return the xAxis
	 */
	protected double getxAxis() {
		return xAxis;
	}

	/**
	 * @param yAxis the yAxis to set
	 */
	protected void setyAxis(double yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * @return the yAxis
	 */
	protected double getyAxis() {
		return yAxis;
	}

	/**
	 * @param gridHeight the gridHeight to set
	 */
	protected void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}

	/**
	 * @return the gridHeight
	 */
	protected int getGridHeight() {
		return gridHeight;
	}

	/**
	 * @param gridWidth the gridWidth to set
	 */
	protected void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	/**
	 * @return the gridWidth
	 */
	protected int getGridWidth() {
		return gridWidth;
	}

	/**
	 * @param xInterval the xInterval to set
	 */
	protected void setxInterval(double xInterval) {
		this.xInterval = xInterval;
	}

	/**
	 * @return the xInterval
	 */
	protected double getxInterval() {
		return xInterval;
	}


	/**
	 * @param center the center to set
	 */
	public void setCenter(Point center) {
		this.screenCenter = center;
	}


	/**
	 * @return the center
	 */
	public Point getCenter() {
		return screenCenter;
	}


	/**
	 * @param xMin the xMin to set
	 */
	protected void setxMin(double xMin) {
		this.xMin = xMin;
	}


	/**
	 * @return the xMin
	 */
	protected double getxMin() {
		return xMin;
	}


	/**
	 * @param xMax the xMax to set
	 */
	protected void setxMax(double xMax) {
		this.xMax = xMax;
	}


	/**
	 * @return the xMax
	 */
	protected double getxMax() {
		return xMax;
	}

	/**
	 * drawPoints - draws several points on the grid
	 * @param points
	 * @param graphics
	 */
	public void drawPoints(Point[] points, Graphics graphics) {
		// TODO Auto-generated method stub
		gridPoints = points;
	}

	/**
	 * drawPoint - draws a single point on the grid
	 * @param pointX
	 * @param pointY
	 * @param graphics
	 */
	public void drawPoint(int pointX, int pointY) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)this.getGraphics();
		pointX += xDiff;
		pointY += yDiff;
		g2d.drawArc(pointX, pointY, 50, 50, 0, 360);
	}
}
