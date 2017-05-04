import java.awt.Color;
import javax.swing.ImageIcon;

public class GUITest {

	private static MancalaBoard board;

	public static void main(String[] args)
	{
		SimpleBoardStyle highContrast = new SimpleBoardStyle();
		highContrast.setBGColor(Color.WHITE);
		highContrast.setActivePitBorderColor(Color.BLUE);
		highContrast.setInactivePitBorderColor(Color.GRAY);
		highContrast.setStoneColor(Color.BLACK);
		highContrast.setPitBorderStrokeWidth(15);
		//highContrast.setStoneIcon(new ImageIcon("stoneIcon.png"));
		highContrast.setPitWidth(200);
		highContrast.setPadding(2.0);

		board = new MancalaBoard(new MancalaModel(3), highContrast);	
	}	

}
