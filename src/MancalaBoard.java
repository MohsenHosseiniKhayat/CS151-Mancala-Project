import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaBoard extends JFrame implements ChangeListener{

	protected MancalaBoard(MancalaModel modelIn, BoardStyle styleIn)
	{
		pits = new MancalaPit[2][7];
		style = styleIn;
		model = modelIn;
		setupBoard();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(getWidth() + 100, getHeight() + 100));
		setVisible(true);
	}
	
	private void setupBoard()
	{
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		JPanel mancalaPanel = new JPanel();
		mancalaPanel.setBackground(style.getBGColor());
		mancalaPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mB = new MancalaPit(0, 6, style);
		mancalaPanel.add(mB, c);
		pits[0][6] = mB;
		
		c = new GridBagConstraints();
		c.gridx = 7;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mA = new MancalaPit(1, 6, style);
		mancalaPanel.add(mA, c);
		pits[1][6] = mB;
		
		int row = 0;
		for(int col = 5; col >= 0; col--)
		{
			c = new GridBagConstraints();
			c.gridx = col + 1;
			c.gridy = row;
			c.fill = GridBagConstraints.NONE;
			
			MancalaPit pit = new MancalaPit(row, col, style);
			mancalaPanel.add(pit, c);
			pits[row][col] = pit;
		}
		
		row = 1;
		for(int col = 0; col < 6; col++)
		{
			c = new GridBagConstraints();
			c.gridx = col + 1;
			c.gridy = row;
			c.fill = GridBagConstraints.NONE;
			
			MancalaPit pit = new MancalaPit(row, col, style);
			mancalaPanel.add(pit, c);
			pits[row][col] = pit;
		}
		
		
		
		mancalaPanel.setBorder(new StrokeBorder(new BasicStroke(1)));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton undoButton = new JButton("Undo Move");
		JButton endTurnButton = new JButton("End Turn");
		
		buttonPanel.add(undoButton);
		buttonPanel.add(endTurnButton);
		buttonPanel.setBackground(Color.GRAY);
		
		add(mancalaPanel);
		add(buttonPanel);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		model.getCurrentPlayer();
		
	}

	MancalaModel model;
	MancalaPit[][] pits;
	BoardStyle style;
	
}
