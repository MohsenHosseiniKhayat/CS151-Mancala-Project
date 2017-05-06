import javax.swing.JOptionPane;

public class MancalaTest {
	public static void main(String[] args) {
		
		String[] options = { "4", "3" };
		int selected = JOptionPane.showOptionDialog(null, "Choose the number of stones in each pit: ", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		int numberOfStones = Integer.parseInt(options[selected]);

		MancalaModel model = new MancalaModel(numberOfStones);

		System.out.println(model.getEndOfTurn());
		model.takeTurn(model.getCurrentPlayer(), 1, 3);
		System.out.println(model.getEndOfTurn());
		model.switchPlayer();
		System.out.println(model.getEndOfTurn());
		model.takeTurn(model.getCurrentPlayer(), 0, 2);
		System.out.println(model.getEndOfTurn());
	}
}
