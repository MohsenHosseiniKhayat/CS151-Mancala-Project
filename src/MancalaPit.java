<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
=======
import java.awt.*;
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

<<<<<<< HEAD
import javax.swing.JLabel;
=======
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class MancalaPit extends JPanel implements ChangeListener{
	/**
	 * Constructor
	 * @param row - the row of this pit
	 * @param col
	 */
	public MancalaPit(final int row, final int col, final MancalaModel model, BoardStyle styleIn)
	{
		this.row = row;
		this.col = col;
		this.model = model;
		this.stones = new ArrayList<Stone>();
<<<<<<< HEAD
		this.active = true;
=======
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
		
		style = styleIn;	
		random = new Random();
		
		double pitWidth = style.getPitWidth();
		if(col == 7)
			setPreferredSize(new Dimension((int) pitWidth, (int) (2*pitWidth)));
		else
			setPreferredSize(new Dimension((int) pitWidth, (int) pitWidth));	
		
		for(int i = 0; i < model.getStonesAtPit(row, col); i++)
<<<<<<< HEAD
		{
			Stone stone = new Stone(0, 0, getWidth() / 5);
			int d = (int) (random.nextDouble() * (getWidth() / 2 - stone.getWidth()));

			double theta = random.nextDouble() * 2 * Math.PI;
			stone.setX((int)(this.getWidth()  / 2 + d * Math.cos(theta) - stone.getWidth() / 2 - style.getGutterWidth()));
			stone.setY((int)(this.getHeight() / 2 + d * Math.sin(theta) - stone.getWidth() / 2 - style.getGutterWidth()));
			stones.add(stone);
		}
		
		this.add(pitLabel);
=======
		{			
			Random random = new Random();
			Stone stone = new Stone(0, 0, pitWidth/ 5);
			int d = (int)(random.nextDouble() * (pitWidth - gutterWidth) / 2 - stone.getWidth());
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project

<<<<<<< HEAD
=======
			double theta = random.nextDouble()*2*Math.PI;
			stone.setX((int)(pitWidth / 2 + d * Math.cos(theta)) - stone.getWidth() / 2);
			stone.setY((int)(pitWidth / 2 + d * Math.sin(theta)) - stone.getHeight() / 2);
			stones.add(stone);
		}
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
		
		this.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
<<<<<<< HEAD
						if(active)
						{
							System.out.print(model.toString());
							//System.out.printf("Clicked:\nRow: %d, Column: %d\n", row, col);
							model.takeTurn(model.getCurrentPlayer(), row, col);
							System.out.print(model.toString());
						}
=======
						model.printBoard();
						System.out.printf("Clicked:\nRow: %d, Column: %d\n", row, col);
						model.takeTurn(model.getCurrentPlayer(), row, col);
						model.printBoard();
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
					}
				});
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
											   RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setRenderingHints(rh);
		
<<<<<<< HEAD
		double pitWidth = style.getPitWidth();
		double gutterWidth = style.getGutterWidth();
		
		g2.setBackground(style.getBGColor());
		g2.clearRect(0, 0, this.getWidth(), this.getHeight());
=======
		pitWidth = style.getPitWidth();
		gutterWidth = style.getGutterWidth();
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project

		g2.setStroke(style.getPitBorderStroke());
		g2.setColor(active ? style.getActivePitBorderColor() : style.getInactivePitBorderColor());
		
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
<<<<<<< HEAD
			s.paintComponent(g);
		}
		
		pitLabel.setForeground(Color.RED);
		pitLabel.setFont(new Font("ARIAL", Font.BOLD, 60));
		pitLabel.setText("" + stones.size());
=======
			s.paintComponent(g2);
		}
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		ArrayList<Stone> oldStones = stones;
		stones = new ArrayList<Stone>();
<<<<<<< HEAD
		for(int i = 0; i < model.getStonesAtPit(row, col); i++)
		{
			Stone stone = new Stone(0, 0, getWidth() / 5);
			int d = (int) (random.nextDouble() * (getWidth() / 2 - stone.getWidth()));
=======
		this.paintComponent(this.getGraphics());
		
	}
>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project

			double theta = random.nextDouble() * 2 * Math.PI;
			stone.setX((int)(this.getWidth()  / 2 + d * Math.cos(theta) - stone.getWidth() / 2 - style.getGutterWidth()));
			stone.setY((int)(this.getHeight() / 2 + d * Math.sin(theta) - stone.getWidth() / 2 - style.getGutterWidth()));
			stones.add(stone);
		}
		paintComponent(getGraphics());
	}
	/*
	/**
	 * Returns the number of stones the mancala pit has and will draw
	 * @param numStones The number of stones in the pit
	 * /
	public void setNumStones (int numStones)
	{
		this.numStones = numStones;
	}
	
	

	/**
	 * Returns the number of stones in the mancala pit
	 * @return numstones The number of stones in the mancala pit
	 * /
	public int getNumStones () {return numStones;}
	 */
	
	public void setActive(boolean value)
	{
		active = value;
	}
	
	//private int numStones;
	private int row;
	private int col;
	private int id;
	private MancalaModel model;
	private BoardStyle style;
	private ArrayList<Stone> stones;
<<<<<<< HEAD
	private static Random random;
	
	private boolean active;
	final JLabel pitLabel = new JLabel();
=======
	private double pitWidth;
	private double gutterWidth;

>>>>>>> branch 'iain' of https://github.com/MohsenHosseiniKhayat/CS151-Mancala-Project
}
