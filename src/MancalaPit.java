import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.border.StrokeBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaPit extends JPanel implements ChangeListener{
	/**
	 * Constructor
	 * @param row - the row of this pit
	 * @param col
	 */
	public MancalaPit(int row, int col)
	{
		super();
		this.row = row;
		this.col = col;
		
		if(col == 7)
			setPreferredSize(new Dimension((int) PIT_WIDTH, (int) (2*PIT_WIDTH)));
		else
			setPreferredSize(new Dimension((int) PIT_WIDTH, (int) PIT_WIDTH));
		
		this.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						System.out.printf("Clicked:\nRow: %d, Column: %d\n", row, col);
					}
				});
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(5));
		
		Point2D.Double p1 = new Point2D.Double(GUTTER_WIDTH, PIT_WIDTH / 2);
		Point2D.Double p2 = new Point2D.Double(GUTTER_WIDTH, getHeight() - PIT_WIDTH / 2);
		Line2D.Double l1 = new Line2D.Double(p1, p2);
		
		Point2D.Double p3 = new Point2D.Double(PIT_WIDTH - GUTTER_WIDTH, PIT_WIDTH / 2);
		Point2D.Double p4 = new Point2D.Double(PIT_WIDTH - GUTTER_WIDTH, getHeight() - PIT_WIDTH / 2);
		Line2D.Double l2 = new Line2D.Double(p3, p4);
		
		Arc2D.Double a1 = new Arc2D.Double((double) GUTTER_WIDTH, 
										   (double) GUTTER_WIDTH, 
										   (double) PIT_WIDTH - 2 * GUTTER_WIDTH, 
										   (double) PIT_WIDTH - 2 * GUTTER_WIDTH,
										   (double)0, 
										   (double) 180, Arc2D.OPEN);
		g2.draw(a1);
		
		Arc2D.Double a2 = new Arc2D.Double((double) GUTTER_WIDTH,
										   (double) this.getHeight() - PIT_WIDTH + GUTTER_WIDTH,
										   (double) PIT_WIDTH - 2 * GUTTER_WIDTH,
										   (double) PIT_WIDTH - 2 * GUTTER_WIDTH,
										   180.0, 
										   180.0, 
										   Arc2D.OPEN);
		g2.draw(a2);
		
		g2.draw(l1);
		g2.draw(l2);
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private int numStones;
	private int row;
	private int col;
	private int id;
	private static double PIT_WIDTH = 90.0;
	private static double GUTTER_WIDTH = 4;
	private MancalaModel model;
	

}
