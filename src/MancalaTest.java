import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JOptionPane;

public class MancalaTest {
	private static FancyBoardStyle colorful = new FancyBoardStyle();
	private static SimpleBoardStyle highContrast = new SimpleBoardStyle();
	
	
	public static void main(String[] args) {
		initBoardStyles();
		
		String[] options_numStones = { "4", "3" };
		String[] options_boardStyle = { "Black and White", "Colorful"};
		int selected = JOptionPane.showOptionDialog(null, "Choose the number of stones in each pit: ", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options_numStones, null);
		int numberOfStones = Integer.parseInt(options_numStones[selected]);


		selected = JOptionPane.showOptionDialog(null, "Choose the board style: ", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options_boardStyle, null);
		BoardStyle style = selected == 1 ? colorful : highContrast;
		
		
		MancalaModel model = new MancalaModel(numberOfStones);
		new MancalaBoard(model, style);
	}
	
	private static void initBoardStyles()
	{
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
		
		
		highContrast.setBGColor(Color.WHITE);
		highContrast.setActivePitBorderColor(Color.BLACK);
		highContrast.setInactivePitBorderColor(Color.LIGHT_GRAY);
		highContrast.setActivePitBorderStrokeWidth(10);
		highContrast.setInactivePitBorderStrokeWidth(3);
		highContrast.setPitWidth(200);
		highContrast.setPadding(2.0);
		
		highContrast.setStoneFillColor(Color.BLACK);
		highContrast.setStoneStrokeColor(Color.WHITE);
		highContrast.setStoneStrokeWidth(5);
		
		highContrast.setPlayerAColor(Color.WHITE);
		highContrast.setPlayerBColor(Color.WHITE);
	}
}
