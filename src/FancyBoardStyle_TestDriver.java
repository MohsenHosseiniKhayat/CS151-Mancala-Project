import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class FancyBoardStyle_TestDriver {

	private static MancalaBoard board;

	public static void main(String[] args)
	{
		FancyBoardStyle colorful = new FancyBoardStyle();
		
		colorful.setBGColor(Color.LIGHT_GRAY);
		colorful.setActivePitBorderColor(Color.RED);
		colorful.setInactivePitBorderColor(Color.GRAY);
		colorful.setActivePitBorderStrokeWidth(10);
		colorful.setInactivePitBorderStrokeWidth(5);
		colorful.setPitWidth(200);
		colorful.setPadding(2.0);
		
		colorful.addStoneColor(Color.BLUE);
		colorful.addStoneColor(Color.CYAN);
		colorful.addStoneColor(Color.MAGENTA);
		colorful.addStoneColor(Color.GREEN);
		colorful.addStoneColor(Color.MAGENTA);
		colorful.addStoneColor(Color.ORANGE);
		colorful.addStoneColor(Color.RED);
		colorful.addStoneColor(Color.YELLOW);
		
		colorful.addStoneShape(new RoundRectangle2D.Double());
		colorful.addStoneShape(new Ellipse2D.Double());
		colorful.addStoneShape(new Rectangle2D.Double());
		
		colorful.setStoneStrokeColor(Color.BLACK);
		colorful.setStoneStrokeWidth(3);

		colorful.setPlayerAColor(Color.CYAN);
		colorful.setPlayerBColor(Color.PINK);
		
		board = new MancalaBoard(new MancalaModel(3), colorful);
	}	

}
