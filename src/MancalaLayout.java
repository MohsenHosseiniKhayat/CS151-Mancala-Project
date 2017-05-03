import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class MancalaLayout implements LayoutManager{


	@Override
	public void layoutContainer(Container parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		MancalaPit mParent = (MancalaPit)parent;
		
		
		return null;
	}
	
	// do-nothing legacy methods
	@Override
	public void removeLayoutComponent(Component comp) {}
	@Override
	public void addLayoutComponent(String name, Component comp) {}
	
	private int centerX;
	private int centerY;
}
