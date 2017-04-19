import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

public interface BoardStyle 
{
	public void		setBGColor(Color newBGColor);
	public Color	getBGColor();
	
	public void		setPitBorderColor(Color newPitBorderColor);
	public Color	getPitBorderColor();
	
	public void		setPitBorderStrokeWidth(int newStrokeWidth);
	public Stroke	getPitBorderStroke();
	
	public void		setStoneColor(Color newStoneColor);
	public Color	getStoneColor();
	
	public void		setStoneShape(Shape newShape);
	public Shape	getStoneShape();
	
	public void  	setPitWidth(int newWidth);
	public double	getPitWidth();
	
	public double	getGutterWidth();
}
