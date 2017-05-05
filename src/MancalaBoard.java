import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaBoard extends JFrame implements ChangeListener{

	protected MancalaBoard(MancalaModel modelIn, BoardStyle styleIn)
	{
		style = styleIn;
		model = modelIn;
		model.attach(this);
		playerPits = new ArrayList[2];
		playerPits[0] = new ArrayList<MancalaPit>();
		playerPits[1] = new ArrayList<MancalaPit>();

		setupBoard();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(getWidth() + 100, getHeight() + 100));
		setVisible(true);
	}
	
	private void setupBoard()
	{
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		currentPlayerPanel.add(currentPlayerLabel);
		this.add(currentPlayerPanel);
		JPanel mancalaPanel = new JPanel();
		mancalaPanel.setBackground(style.getBGColor());
		mancalaPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mB = new MancalaPit(0, 6, model, style);
		mB.setActive(false);
		model.attach(mB);
		mancalaPanel.add(mB, c);
		
		c = new GridBagConstraints();
		c.gridx = 7;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		
		MancalaPit mA = new MancalaPit(1, 6, model, style);
		mA.setActive(false);
		model.attach(mA);
		mancalaPanel.add(mA, c);

		int row = 0;

		for(int col = 5; col >= 0; col--)
		{
			c = new GridBagConstraints();
			c.gridx = 6 - col;
			c.gridy = row;
			c.fill = GridBagConstraints.NONE;


			MancalaPit pit = new MancalaPit(row, col, model, style);
			model.attach(pit);
			mancalaPanel.add(pit, c);
			playerPits[row].add(pit);
		}
		
		row = 1;
		for(int col = 0; col <= 5; col++)
		{
			c = new GridBagConstraints();
			c.gridx = col + 1;
			c.gridy = row;
			c.fill = GridBagConstraints.NONE;

			MancalaPit pit = new MancalaPit(row, col, model, style);
            //Check this out please, I'm not sure if this is right
			model.attach(pit);
			mancalaPanel.add(pit, c);
			playerPits[row].add(pit);
		}
		
		mancalaPanel.setBorder(new StrokeBorder(new BasicStroke(1)));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		final JButton undoButton = new JButton("Undo Move");
		final JButton endTurnButton = new JButton("End Turn");
		
		undoButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                model.undoLastMove();
            }
        });
		undoButton.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                    undoButton.setEnabled(model.getCurrentPlayer().canPlayerUndo());
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
		endTurnButton.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                endTurnButton.setEnabled(model.getEndOfTurn());
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
		int thisRow = model.getCurrentPlayer().getRow();
		int thatRow = (thisRow + 1) % 2;
		for(MancalaPit mp : playerPits[thisRow])
		{
			mp.setActive(true);
		}
		for(MancalaPit mp: playerPits[thatRow])
		{
			mp.setActive(false);
		}

		currentPlayerLabel.setText(thisRow == 0 ? "Player B" : "Player A");
		currentPlayerPanel.setBackground(thisRow == 0 ? Color.ORANGE : Color.PINK);
		currentPlayerPanel.setLayout(new FlowLayout(thisRow == 0 ? FlowLayout.LEFT : FlowLayout.RIGHT));
		
	}

	MancalaModel model;
	BoardStyle style;
	ArrayList<MancalaPit>[] playerPits;
	final JLabel currentPlayerLabel = new JLabel();
	final JPanel currentPlayerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
}
