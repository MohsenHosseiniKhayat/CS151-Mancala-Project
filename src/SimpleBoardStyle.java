import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.border.Border;
import javax.swing.border.StrokeBorder;

public class SimpleBoardStyle implements BoardStyle{
	
	private Color	BGColor;
	private Color	sitBorderColor;
	private Color	stoneColor;
	private Color	pitBorderColor;
	private Stroke	pitStroke;
	private Shape	stoneShape;
	private double	pitWidth;
	private double	gutterWidth;
	private int		strokeWidth;
	
	
	@Override
	public void setBGColor(Color newBGColor) {
		BGColor = newBGColor;
		return;
	}
	
	@Override
	public Color getBGColor()
	{
		return BGColor;
	}
	
	@Override
	public void setPitBorderColor(Color newPitBorderColor) {
		pitBorderColor = newPitBorderColor;
		return;
	}
	
	@Override
	public Color getPitBorderColor()
	{
		return pitBorderColor;
	}
	
	@Override
	public void setPitBorderStrokeWidth(int newStrokeWidth) {
		strokeWidth = newStrokeWidth;
		gutterWidth = (double) newStrokeWidth * 2 / 5;
		pitStroke = new BasicStroke(newStrokeWidth);
		return;
	}
	
	@Override
	public Stroke getPitBorderStroke()
	{
		return pitStroke;
	}
	
	@Override
	public void setStoneColor(Color newStoneColor) {
		stoneColor = newStoneColor;
		return;
	}
	
	@Override
	public Color getStoneColor()
	{
		return stoneColor;
	}
	
	@Override
	public void setStoneShape(Shape newShape) {
		stoneShape = newShape;
	}
	
	@Override
	public Shape getStoneShape()
	{
		return stoneShape;
	}
	
	@Override
	public void setPitWidth(int newWidth) {
		pitWidth = newWidth;
	}
	
	@Override
	public double getPitWidth()
	{
		return pitWidth;
	}

	@Override
	public double getGutterWidth() {
		return (double) strokeWidth / 2 + 1;
	}
}
