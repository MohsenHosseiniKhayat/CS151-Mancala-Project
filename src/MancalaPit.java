import java.awt.Dimension;
import java.awt.FlowLayout;
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
		this.stones = new ArrayList<Stone>();
		
		style = styleIn;		
		
		double pitWidth = style.getPitWidth();
		if(col == 7)
			setPreferredSize(new Dimension((int) pitWidth, (int) (2*pitWidth)));
		else
			setPreferredSize(new Dimension((int) pitWidth, (int) pitWidth));	
		
		for(int i = 0; i < model.getStonesAtPit(row, col); i++)
		{			
			Random random = new Random();
			Stone stone = new Stone(0, 0, pitWidth/ 5);
			int d = (int)(random.nextDouble() * (pitWidth - gutterWidth) / 2 - stone.getWidth());

			double theta = random.nextDouble()*2*Math.PI;
			stone.setX((int)(pitWidth / 2 + d * Math.cos(theta)) - stone.getWidth() / 2);
			stone.setY((int)(pitWidth / 2 + d * Math.sin(theta)) - stone.getHeight() / 2);
			stones.add(stone);
		}
		
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
		
		pitWidth = style.getPitWidth();
		gutterWidth = style.getGutterWidth();

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
		
		for(Stone s: stones)
		{
			s.paintComponent(g2);
		}
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		this.paintComponent(this.getGraphics());
		
	}

	private int numStones;
	private int row;
	private int col;
	private int id;
	private MancalaModel model;
	private BoardStyle style;
	private ArrayList<Stone> stones;
	private double pitWidth;
	private double gutterWidth;

}
