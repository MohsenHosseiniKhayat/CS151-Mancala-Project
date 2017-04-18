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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

public class GUITest {

	public static void main(String[] args)
	{
		JFrame mancalaFrame = new JFrame();
		mancalaFrame.setLayout(new BoxLayout(mancalaFrame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel mancalaPanel = new JPanel();
		mancalaPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mB = new MancalaPit(0, 7);
		mancalaPanel.add(mB, c);
		
		c = new GridBagConstraints();
		c.gridx = 7;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mA = new MancalaPit(1, 7);
		mancalaPanel.add(mA, c);

		for(int row = 0; row < 2; row++)
		{
			for(int col = 1; col < 7; col++)
			{
				c = new GridBagConstraints();
				c.gridx = col;
				c.gridy = row;
				c.fill = GridBagConstraints.NONE;
				
				MancalaPit pit = new MancalaPit(row, col);
				mancalaPanel.add(pit, c);
				mancalaPanel.setBorder(new StrokeBorder(new BasicStroke(1)));
			}
		}
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton undoButton = new JButton("Undo Move");
		JButton endTurnButton = new JButton("End Turn");
		
		buttonPanel.add(undoButton);
		buttonPanel.add(endTurnButton);
		buttonPanel.setBackground(Color.GRAY);
		
		mancalaFrame.add(mancalaPanel);
		mancalaFrame.add(buttonPanel);
		
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.pack();
		mancalaFrame.setMinimumSize(new Dimension(mancalaFrame.getWidth() + 100, mancalaFrame.getHeight() + 100));
		mancalaFrame.setVisible(true);
	}
}
