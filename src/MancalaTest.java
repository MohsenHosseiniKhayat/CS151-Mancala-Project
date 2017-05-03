import sun.java2d.pipe.SpanShapeRenderer;

public class MancalaTest {
    public static void main (String [] args)
    {
        MancalaModel model = new MancalaModel(4);
        SimpleBoardStyle style = new SimpleBoardStyle();
        CreateAndAttachPits(model, style);

        printStatus(model);

        model.takeTurn(model.getCurrentPlayer(),1,1);           //Player A takes legal turn
        String lastTurn =  printStatus(model);
        model.switchPlayer();
        model.takeTurn(model.getCurrentPlayer(),1, 2);          //Player B takes illegal turn
        printStatus(model);
        model.takeTurn(model.getCurrentPlayer(),0,3);           //Player B takes legal turn
        printStatus(model);
        model.undoLastMove();
        String recentTurn = printStatus(model);
        System.out.println(recentTurn.equals(lastTurn));

    }

    private static void CreateAndAttachPits(MancalaModel model, SimpleBoardStyle style)
    {
        MancalaPit pit1 = new MancalaPit (0, 0, style);
        model.attach(pit1);
        MancalaPit pit2 = new MancalaPit (0, 1, style);
        model.attach(pit2);
        MancalaPit pit3 = new MancalaPit (0, 2, style);
        model.attach(pit3);
        MancalaPit pit4 = new MancalaPit (0, 3, style);
        model.attach(pit4);
        MancalaPit pit5 = new MancalaPit (0, 4, style);
        model.attach(pit5);
        MancalaPit pit6 = new MancalaPit (0, 5, style);
        model.attach(pit6);
        MancalaPit pit7 = new MancalaPit (0, 6, style);
        model.attach(pit7);
        MancalaPit pit8 = new MancalaPit (1, 0, style);
        model.attach(pit8);
        MancalaPit pit9 = new MancalaPit (1, 1, style);
        model.attach(pit9);
        MancalaPit pit10 = new MancalaPit (1, 2, style);
        model.attach(pit10);
        MancalaPit pit11 = new MancalaPit (1, 3, style);
        model.attach(pit11);
        MancalaPit pit12 = new MancalaPit (1, 4, style);
        model.attach(pit12);
        MancalaPit pit13 = new MancalaPit (1, 5, style);
        model.attach(pit13);
        MancalaPit pit14 = new MancalaPit (1, 6, style);
        model.attach(pit14);
    }

    static int testNum = 0;

    public static String printStatus (MancalaModel model)
    {
        String result = "";
        for (int i = 0; i<model.getMancalaPits().size(); i++)
        {
            result += " pit [" + i + "] : " + model.getMancalaPits().get(i).getNumStones();
        }
        testNum++;
        System.out.println(result);
        System.out.println("---------------------" + testNum + "-------------------------------");
        return result;
    }
}
