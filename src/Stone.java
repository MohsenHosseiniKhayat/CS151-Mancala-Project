import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

<<<<<<< HEAD
=======
import javax.swing.Icon;
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
import javax.swing.JComponent;

public class Stone extends JComponent{
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
		this.strokeColor = Color.BLUE;
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
<<<<<<< HEAD
		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, width, height);
		g2.setColor(fillColor);
		g2.fill(shape);
		g2.setColor(strokeColor);
		g2.draw(shape);
=======
		g2.setColor(this.fillColor);
		g2.fill(new Ellipse2D.Double(x, y, width, width));
		g2.setStroke(new BasicStroke(5));
		g2.setColor(this.strokeColor);
		g2.draw(new Ellipse2D.Double(x, y, width, width));

>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
	}
}
