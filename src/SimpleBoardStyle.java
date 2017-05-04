import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;
import javax.swing.Icon;
import javax.swing.border.Border;
import javax.swing.border.StrokeBorder;

public class SimpleBoardStyle implements BoardStyle{
	
	private Color	BGColor;
	private Color	sitBorderColor;
	private Color	stoneColor;
	private Color	activePitBorderColor;
	private Color	inactivePitBorderColor;
	private Stroke	pitStroke;
	private Icon	stoneIcon;
	private double	pitWidth;
	private double	gutterWidth;
	private int		strokeWidth;
	private double  padding;
	
	
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
	public void setActivePitBorderColor(Color newPitBorderColor) {
		activePitBorderColor = newPitBorderColor;
		return;
	}
	
	@Override
	public Color getActivePitBorderColor()
	{
		return activePitBorderColor;
	}
	
	@Override
	public void setInactivePitBorderColor(Color newPitBorderColor) {
		inactivePitBorderColor = newPitBorderColor;
		return;
	}
	
	@Override
	public Color getInactivePitBorderColor()
	{
		return inactivePitBorderColor;
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
		return (double) strokeWidth / 2 + padding;
	}

	@Override
	public double getPadding() {
		return padding;
	}

	@Override
	public void setPadding(double padding) {
		this.padding = padding;
	}

	@Override
	public Stone getStone() {
		return new Stone(0, 0, pitWidth/4);
	}
}
