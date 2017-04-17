import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;

public class MancalaPit extends JPanel{
	/**
	 * Constructor
	 * @param row - the row of this pit
	 * @param col
	 */
	public MancalaPit(int row, int col)
	{
		this.row = row;
		this.col = col;
		
		if(col == 7)
			setPreferredSize(new Dimension(PIT_WIDTH, 2*PIT_WIDTH));
		else
			setPreferredSize(new Dimension(PIT_WIDTH, PIT_WIDTH));
		
		this.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						System.out.printf("Clicked:\nRow: %d, Column: %d\n", row, col);
					}
				});
		
		setBorder(new StrokeBorder(new BasicStroke(1)));
	}


	private int numStones;
	private int row;
	private int col;
	private int id;
	private static int PIT_WIDTH = 40;
}
