import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.RectangularShape;

public interface BoardStyle 
{
	// pit border style
	public void		setActivePitBorderStrokeWidth(int strokeWidthIn);
	public void 	setInactivePitBorderStrokeWidth(int strokeWidthIn);
	public void 	setPitBorderStrokeWidth(int strokeWidthIn);
	
	public Stroke	getActivePitStroke();
	public Stroke 	getInactivePitStroke();
	
	public void		setActivePitBorderColor(Color pitBorderColorIn);
	public Color	getActivePitBorderColor();
	
	public void		setInactivePitBorderColor(Color pitBorderColorIn);
	public Color	getInactivePitBorderColor();
	
	// stone style
	public void		setStoneStrokeColor(Color stoneStrokeColorIn);
	public Color	getStoneStrokeColor();
	public void 	setStoneFillColor(Color stoneFillColorIn);
	public Color	getStoneFillColor();
	public void 	setStoneStrokeWidth(int stoneStrokeWidthIn);
	public int		getStoneStrokeWidth();
	public RectangularShape	getStoneShape();
	
	// board style
	public void  	setPitWidth(int width);
	public double	getPitWidth();
	
	public double	getGutterWidth();
	
	public double	getPadding();
	public void		setPadding(double padding);
	
	public void		setBGColor(Color BGColorIn);
	public Color	getBGColor();
	
	public void		setPlayerAColor(Color PAColorIn);
	public Color	getPlayerAColor();
	public void		setPlayerBColor(Color PBColorIn);
	public Color	getPlayerBColor();
	
	public void		applyStyle(Stone stone);
}
