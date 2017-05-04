import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class MancalaPit extends JPanel implements ChangeListener{
	/**
	 * Constructor
	 * @param row - the row of this pit
	 * @param col
	 */
	public MancalaPit(int row, int col, MancalaModel model, BoardStyle styleIn)
	{
		this.row = row;
		this.col = col;
		this.model = model;
		
		style = styleIn;		
		
		double pitWidth = style.getPitWidth();
		if(col == 7)
			setPreferredSize(new Dimension((int) pitWidth, (int) (2*pitWidth)));
		else
			setPreferredSize(new Dimension((int) pitWidth, (int) pitWidth));
		
		JPanel stonesPanel = new JPanel();
		
		for(int i = 0; i < numStones; i++)
		{
			Stone stone = new Stone(i, i, pitWidth);
			int d = (int) (pitWidth / 2 - stone.getWidth() / 2);
			Random random = new Random();
			double theta = random.nextDouble();
			stone.setX((int)(d * Math.cos(theta)));
			stone.setY((int)(d * Math.sin(theta)));
			stonesPanel.add(stone);
		}

		add(stonesPanel);
		
		
		stonesPanel.setOpaque(false);
		stonesPanel.repaint();
		
		this.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						model.printBoard();
						System.out.printf("Clicked:\nRow: %d, Column: %d\n", row, col);
						model.takeTurn(model.getCurrentPlayer(), row, col);
						model.printBoard();
					}
				});
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
											   RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setRenderingHints(rh);
		
		double pitWidth = style.getPitWidth();
		double gutterWidth = style.getGutterWidth();

		g2.setStroke(style.getPitBorderStroke());
		
		Point2D.Double p1 = new Point2D.Double(gutterWidth, pitWidth / 2);
		Point2D.Double p2 = new Point2D.Double(gutterWidth, getHeight() - pitWidth / 2);
		Line2D.Double l1 = new Line2D.Double(p1, p2);
		
		Point2D.Double p3 = new Point2D.Double(pitWidth - gutterWidth, pitWidth / 2);
		Point2D.Double p4 = new Point2D.Double(pitWidth - gutterWidth, getHeight() - pitWidth / 2);
		Line2D.Double l2 = new Line2D.Double(p3, p4);
		
		Arc2D.Double a1 = new Arc2D.Double((double) gutterWidth, 
										   (double) gutterWidth, 
										   (double) pitWidth - 2 * gutterWidth, 
										   (double) pitWidth - 2 * gutterWidth,
										   (double)0, 
										   (double) 180, Arc2D.OPEN);
		g2.draw(a1);
		
		Arc2D.Double a2 = new Arc2D.Double((double) gutterWidth,
										   (double) this.getHeight() - pitWidth + gutterWidth,
										   (double) pitWidth - 2 * gutterWidth,
										   (double) pitWidth - 2 * gutterWidth,
										   180.0, 
										   180.0, 
										   Arc2D.OPEN);
		g2.draw(a2);
		
		g2.draw(l1);
		g2.draw(l2);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		
	}

	/**
	 * Returns the number of stones the mancala pit has and will draw
	 * @param numStones The number of stones in the pit
	 */
	public void setNumStones (int numStones)
	{
		this.numStones = numStones;
	}

	/**
	 * Returns the number of stones in the mancala pit
	 * @return numstones The number of stones in the mancala pit
	 */
	public int getNumStones () {return numStones;}
//>>>>>>> branch 'master' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project

	private int numStones;
	private int row;
	private int col;
	private int id;
	private MancalaModel model;
	private BoardStyle style;
	private ArrayList<Stone> stones;

}
