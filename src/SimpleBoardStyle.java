import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;

<<<<<<< HEAD
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
	public void setStoneIcon(Icon iconIn) {
		stoneIcon = iconIn;
		return;
	}
	
	@Override
	public Icon getStoneIcon()
	{
		return stoneIcon;
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
=======
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
>>>>>>> branch 'master' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
	}
}
