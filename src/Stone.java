import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class Stone extends Component{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color fillColor;
	private Color strokeColor;
	private Shape shape;
	
	protected Stone(int x, int y, Shape shapeIn)
	{
		this.x = x;
		this.y = y;
		this.height = (int) shape.getBounds2D().getHeight();
		this.width = (int) shape.getBounds2D().getWidth();
		this.fillColor = Color.BLACK;
		this.strokeColor = Color.BLACK;
	}
	
	protected Stone(int x, int y, double diameter)
	{
		this.x = x;
		this.y = y;
		shape = new Ellipse2D.Double(x, y, diameter, diameter);
		this.height = (int) shape.getBounds2D().getHeight();
		this.width = (int) shape.getBounds2D().getWidth();
		this.fillColor = Color.BLACK;
		this.strokeColor = Color.BLACK;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	protected void setY(int y)
	{
		this.y = y;
	}
	
	protected void setX(int x)
	{
		this.x = x;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(fillColor);
		g2.fill(shape);
		g2.setColor(strokeColor);
		g2.draw(shape);
	}
}