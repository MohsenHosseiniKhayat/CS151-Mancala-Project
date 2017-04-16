import javax.swing.JOptionPane;

public class MancalaTest {

    public static void main(String[] args) {
  
  //String[] styles = {"BLACK AND WHITE STYLE "," COLORFUL STYLE"};
  //int selected = JOptionPane.showOptionDialog(null, "Choose your mancala style: ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
  
    String[] options = {"3","4"};
    int selected = JOptionPane.showOptionDialog(null, "Choose the number of stones in each pit: ", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
    int numberOfStones = Integer.parseInt(options[selected]);
    
    MancalaModel m = new MancalaModel(numberOfStones);
    }
}
