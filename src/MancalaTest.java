//import sun.java2d.pipe.SpanShapeRenderer;

public class MancalaTest {
	/*
    public static void main (String [] args)
    {
        MancalaModel model = new MancalaModel(4);
        SimpleBoardStyle style = new SimpleBoardStyle();
        CreateAndAttachPits(model, style);

        printStatus(model);

        //TEST SCENARIO 1
        model.takeTurn(model.getCurrentPlayer(),1,1);           //Player A takes legal turn
        String lastTurn =  printStatus(model);
        model.switchPlayer();
        model.takeTurn(model.getCurrentPlayer(),1, 2);          //Player B takes illegal turn
        printStatus(model);
        model.takeTurn(model.getCurrentPlayer(),0,3);           //Player B takes legal turn
        printStatus(model);
        model.undoLastMove();                                                //Undo last legal move of player B and check to see if the board state is equal to state after player A's board
        String recentTurn = printStatus(model);
        System.out.println(recentTurn.equals(lastTurn));


        //TEST SCENARIO 2
        model.resetBoard(); //Reset the board to the initial state
        printStatus(model);
        model.takeTurn(model.getCurrentPlayer(),1,2);               //Legal move that Finishes in player A's own Mancala
        printStatus(model);
        model.switchPlayer();
        model.takeTurn(model.getCurrentPlayer(),0,2);               //Legal move that finishes in player B's own Mancala
        printStatus(model);
        model.takeTurn(model.getCurrentPlayer(),0, 3);              //Bonus move that traverses and passes the Mancala
        printStatus(model);

    }

    private static void CreateAndAttachPits(MancalaModel model, SimpleBoardStyle style)
    {
        MancalaPit pit1 = new MancalaPit (0, 0, style);
        model.attach(pit1,0, 0);
        MancalaPit pit2 = new MancalaPit (0, 1, style);
        model.attach(pit2,0,1);
        MancalaPit pit3 = new MancalaPit (0, 2, style);
        model.attach(pit3,0,2);
        MancalaPit pit4 = new MancalaPit (0, 3, style);
        model.attach(pit4,0,3);
        MancalaPit pit5 = new MancalaPit (0, 4, style);
        model.attach(pit5,0,4);
        MancalaPit pit6 = new MancalaPit (0, 5, style);
        model.attach(pit6,0,5);
        MancalaPit pit7 = new MancalaPit (0, 6, style);
        model.attach(pit7,0,6);
        MancalaPit pit8 = new MancalaPit (1, 0, style);
        model.attach(pit8,1,0);
        MancalaPit pit9 = new MancalaPit (1, 1, style);
        model.attach(pit9,1,1);
        MancalaPit pit10 = new MancalaPit (1, 2, style);
        model.attach(pit10,1,2);
        MancalaPit pit11 = new MancalaPit (1, 3, style);
        model.attach(pit11,1,3);
        MancalaPit pit12 = new MancalaPit (1, 4, style);
        model.attach(pit12,1,4);
        MancalaPit pit13 = new MancalaPit (1, 5, style);
        model.attach(pit13,1,5);
        MancalaPit pit14 = new MancalaPit (1, 6, style);
        model.attach(pit14,1,6);
    }

    static int testNum = 0;

    public static String printStatus (MancalaModel model)
    {
        String result = "";
        int counter = 0;
        MancalaPit [][] mancalaPits = model.getMancalaPits();
        for (int i = 0; i<2; i++)
        {
            for (int j = 0; j<7; j++)
            {
                result += " {[" + (counter + 1) + "] : " + mancalaPits[i][j].getNumStones() + "}";
                counter++;
            }
            result +="\n";

        }
        testNum++;
        System.out.println("\n" + result);
        System.out.println("---------------------" + testNum + "-------------------------------");
        return result;
    }
    */
}
