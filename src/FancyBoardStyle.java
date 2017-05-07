import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class FancyBoardStyle implements BoardStyle{
	
	// pit style
	private	int		activePitStrokeWidth;
	private int		inactivePitStrokeWidth;
	private Color	activePitBorderColor;
	private Color	inactivePitBorderColor;
	
	private Stroke	activePitStroke;
	private Stroke	inactivePitStroke;
	
	// stone style
	private Color	stoneStrokeColor;
	private Color	stoneFillColor;
	private int		stoneStrokeWidth;
	private ArrayList<Color> stoneColors;
	private ArrayList<RectangularShape> stoneShapes;
	
	// board style
	private double	pitWidth;
	private double	gutterWidth;
	private double  padding;
	
	private Color	BGColor;
	private Color	playerAColor;
	private Color	playerBColor;

	
	private Random random;
	
	// constructors
	public FancyBoardStyle()
	{
		stoneColors = new ArrayList<Color>();
		stoneShapes = new ArrayList<RectangularShape>();
		
		// make sure that every style has at least one stone color and one stone shape
		stoneColors.add(Color.DARK_GRAY);
		stoneShapes.add(new Ellipse2D.Double());
		
		random = new Random();
	}
	
	
	
	
	
	// pit border style
	@Override
	public void setActivePitBorderStrokeWidth(int strokeWidthIn) {
		activePitStrokeWidth = strokeWidthIn;
		gutterWidth = (double) strokeWidthIn * 2 / 5;
		activePitStroke = new BasicStroke(strokeWidthIn);
	}
	
	@Override
	public void setInactivePitBorderStrokeWidth(int strokeWidthIn) {
		inactivePitStrokeWidth =  strokeWidthIn;
		gutterWidth = (double) strokeWidthIn * 2 / 5;
		//inactivePitStroke = new BasicStroke(strokeWidthIn);
		inactivePitStroke = new BasicStroke(strokeWidthIn, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	}
	

	@Override
	public void setPitBorderStrokeWidth(int strokeWidthIn) {
		activePitStrokeWidth = strokeWidthIn;
		inactivePitStrokeWidth = strokeWidthIn;
		gutterWidth = (double) strokeWidthIn * 2 / 5;
		activePitStroke = new BasicStroke(strokeWidthIn);
		inactivePitStroke = new BasicStroke(strokeWidthIn, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{15}, 0);
	}
	
	@Override
	public Stroke getActivePitStroke()
	{return activePitStroke;}

	@Override
	public Stroke getInactivePitStroke() 
	{return inactivePitStroke;}
	
	@Override
	public void setActivePitBorderColor(Color newPitBorderColor) 
	{activePitBorderColor = newPitBorderColor;}
	
	@Override
	public Color getActivePitBorderColor()
	{return activePitBorderColor;}
	
	@Override
	public void setInactivePitBorderColor(Color pitBorderColorIn) 
	{inactivePitBorderColor = pitBorderColorIn;}
	
	@Override
	public Color getInactivePitBorderColor()
	{return inactivePitBorderColor;}
	
	
	
	// Stone style
	@Override
	public void setStoneStrokeColor(Color stoneStrokeColorIn)
	{stoneStrokeColor = stoneStrokeColorIn;}
	
	@Override
	public Color getStoneStrokeColor() 
	{return stoneStrokeColor;}
	
	@Override
	public void setStoneFillColor(Color stoneFillColorIn) 
	{stoneFillColor = stoneFillColorIn;}

	@Override
	public Color getStoneFillColor() 
	{
		int index = random.nextInt(stoneColors.size());
		return stoneColors.get(index);
	}
	
	public RectangularShape getStoneShape()
	{
		int index = random.nextInt(stoneShapes.size());
		RectangularShape shape = (RectangularShape) stoneShapes.get(index).clone();
		
		double	scaleFactor = random.nextDouble() + 0.25;
		double	stoneWidth = scaleFactor * (pitWidth - gutterWidth) / 5;
		
				scaleFactor = random.nextDouble() + 0.25;
		double	stoneHeight = scaleFactor * (pitWidth - gutterWidth) / 5;
		
		shape.setFrame(new Rectangle2D.Double(0, 0, stoneWidth, stoneHeight));
		return shape;
	}
	
	@Override
	public void setStoneStrokeWidth(int stoneStrokeWidthIn) 
	{stoneStrokeWidth = stoneStrokeWidthIn;}

	@Override
	public int getStoneStrokeWidth() 
	{return stoneStrokeWidth;}
	
	public void addStoneShape(RectangularShape shapeIn)
	{
		stoneShapes.add(shapeIn);
	}
	
	public void addStoneColor(Color colorIn)
	{
		stoneColors.add(colorIn);
	}
	
	
	//Board style
	/**
	 * Mutator method - sets the total space allocated to a pit. (Pits will have
	 * this dimensions squared, mancalas will be width x 2*width). This
	 * effectively controls the size of the board on screen.
	 */
	@Override
	public void setPitWidth(int newWidth) {
		pitWidth = newWidth;
	}
	
	/**
	 * Accessor method - 
	 * @return the base measurement of the mancala pits, i.e. the width of the 
	 * total space allotted to a given pit (which, in most cases, will be larger
	 * than the graphical representation of the pit itself.)
	 */
	@Override
	public double getPitWidth()
	{
		return pitWidth;
	}	
	
	/**
	 * Accessor method -
	 * Used in painting pits to adjust the size of the pits to allow for stroke
	 * width and spacing between pits
	 */
	@Override
	public double getGutterWidth() {
		double strokeWidth = 
				activePitStrokeWidth >= inactivePitStrokeWidth ? 
						activePitStrokeWidth : inactivePitStrokeWidth;
		return strokeWidth / 2 + padding;
	}
	
	@Override
	public void setPadding(double paddingIn) 
	{padding = paddingIn;}
	
	@Override
	public double getPadding()
	{return padding;}

	@Override
	public void setBGColor(Color newBGColor) 
	{BGColor = newBGColor;}
	
	@Override
	public Color getBGColor()
	{return BGColor;}
	
	@Override
	public void setPlayerAColor(Color PAColorIn) 
	{playerAColor = PAColorIn;}
	
	@Override
	public Color getPlayerAColor()
	{return playerAColor;}

	@Override
	public void setPlayerBColor(Color PBColorIn) 
	{playerBColor = PBColorIn;}
	
	@Override
	public Color getPlayerBColor()
	{return playerBColor;}

	@Override
	public void applyStyle(Stone stone) {
		stone.setShape(getStoneShape());
		stone.setStrokeColor(stoneStrokeColor);
		stone.setFillColor(getStoneFillColor());
	}
}
