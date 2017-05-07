import java.awt.Color;
import javax.swing.ImageIcon;

public class SimpleBoardStyle_TestDriver {

	private static MancalaBoard board;

	public static void main(String[] args)
	{
		SimpleBoardStyle highContrast = new SimpleBoardStyle();
		
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
		
		board = new MancalaBoard(new MancalaModel(3), highContrast);
	}	

}
