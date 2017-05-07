import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

import javax.swing.JComponent;

public class Stone extends JComponent{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color fillColor;
	private Color strokeColor;
	private Stroke stoneStroke;
	private Shape shape;
	
	protected Stone(BoardStyle styleIn){
		x = 0;
		y = 0;
		styleIn.applyStyle(this);
		height = (int) shape.getBounds2D().getHeight();
		width = (int) shape.getBounds2D().getWidth();
		stoneStroke = new BasicStroke(styleIn.getStoneStrokeWidth());
	}
	
	protected Stone(int x, int y, double diameter){
		this.x = x;
		this.y = y;
		shape = new Ellipse2D.Double(x, y, diameter, diameter);
		this.height = (int) shape.getBounds2D().getHeight();
		this.width = (int) shape.getBounds2D().getWidth();
		this.fillColor = Color.BLACK;
		this.strokeColor = Color.BLACK;
	}
	
	public int getX() {return x;}
	
	public int getY() {return y;}
	
	protected void setY(int y) {this.y = y;}
	
	protected void setX(int x) {this.x = x;}
	
	protected void setFillColor(Color colorIn)
	{fillColor = colorIn;}
	
	protected void setStrokeColor(Color colorIn)
	{strokeColor = colorIn;}

	protected void setShape(RectangularShape shapeIn)
	{
		shape = shapeIn;
	}
	
	@Override
	public int getHeight() {return height;}

	@Override
	public int getWidth() {return width;}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, width, height);
		g2.setColor(fillColor);
		g2.setStroke(stoneStroke);
		g2.fill(shape);
		g2.setColor(strokeColor);
		g2.draw(shape);
	}
}
