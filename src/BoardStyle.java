import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

<<<<<<< HEAD
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
	
	public Stone	getStone();
=======
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
>>>>>>> branch 'master' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
}
