import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

public class GUITest {

	public static void main(String[] args)
	{
		SimpleBoardStyle highContrast = new SimpleBoardStyle();
		highContrast.setBGColor(Color.WHITE);
		highContrast.setActivePitBorderColor(Color.BLUE);
		highContrast.setInactivePitBorderColor(Color.GRAY);
		highContrast.setStoneColor(Color.BLACK);
		highContrast.setPitBorderStrokeWidth(15);
		highContrast.setStoneIcon(new ImageIcon("stoneIcon.png"));
		highContrast.setPitWidth(200);
		highContrast.setPadding(2.0);

		MancalaBoard board = new MancalaBoard(new MancalaModel(3), highContrast);	
	}	

}
