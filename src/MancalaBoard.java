import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		MancalaPit mB = new MancalaPit(0, 7, style);
		mancalaPanel.add(mB, c);
		
		c = new GridBagConstraints();
		c.gridx = 7;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mA = new MancalaPit(1, 7, style);
		mancalaPanel.add(mA, c);
		
		for(int row = 0; row < 2; row++)
		{
			for(int col = 1; col < 7; col++)
			{
				c = new GridBagConstraints();
				c.gridx = col;
				c.gridy = row;
				c.fill = GridBagConstraints.NONE;
				
				MancalaPit pit = new MancalaPit(row, col, style);
				mancalaPanel.add(pit, c);
			}
		}
		
		mancalaPanel.setBorder(new StrokeBorder(new BasicStroke(1)));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JButton undoButton = new JButton("Undo Move");
		JButton endTurnButton = new JButton("End Turn");

		undoButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.undoLastMove();
            }
        });
		endTurnButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.switchPlayer();
            }
        });

		undoButton.setEnabled(false);
		buttonPanel.add(undoButton);
		buttonPanel.add(endTurnButton);
		buttonPanel.setBackground(Color.GRAY);
		
		add(mancalaPanel);
		add(buttonPanel);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		
	}

	MancalaModel model;
	BoardStyle style;
	
}
