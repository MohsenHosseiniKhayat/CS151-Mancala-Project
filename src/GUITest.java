import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.BoxLayout;
import javax.swing.Icon;
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
import javax.swing.ImageIcon;

public class GUITest {

	private static MancalaBoard board;

	public static void main(String[] args)
	{
		SimpleBoardStyle highContrast = new SimpleBoardStyle();
		highContrast.setBGColor(Color.WHITE);
		highContrast.setActivePitBorderColor(Color.BLACK);
		highContrast.setInactivePitBorderColor(Color.GRAY);
		highContrast.setStoneColor(Color.BLACK);
		highContrast.setPitBorderStrokeWidth(15);
		//highContrast.setStoneIcon(new ImageIcon("stoneIcon.png"));
		highContrast.setPitWidth(200);
		highContrast.setPadding(2.0);

<<<<<<< HEAD
		board = new MancalaBoard(new MancalaModel(3), highContrast);	
=======
		MancalaBoard board = new MancalaBoard(new MancalaModel(3), highContrast);	
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
	}	

}
