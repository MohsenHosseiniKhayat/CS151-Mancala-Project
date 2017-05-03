import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.Icon;

public interface BoardStyle 
{
	public void		setBGColor(Color newBGColor);
	public Color	getBGColor();
	
	public void		setActivePitBorderColor(Color newPitBorderColor);
	public Color	getActivePitBorderColor();
	
	public void		setInactivePitBorderColor(Color newPitBorderColor);
	public Color	getInactivePitBorderColor();
	
	public void		setPitBorderStrokeWidth(int newStrokeWidth);
	public Stroke	getPitBorderStroke();
	
	
	
	public void		setStoneColor(Color newStoneColor);
	public Color	getStoneColor();
	
	public void		setStoneIcon(Icon iconIn);
	public Icon		getStoneIcon();
	
	public void  	setPitWidth(int width);
	public double	getPitWidth();
	
	public double	getGutterWidth();
	
	public double	getPadding();
	public void		setPadding(double padding);
}
