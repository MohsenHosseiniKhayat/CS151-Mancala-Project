import sun.java2d.pipe.SpanShapeRenderer;

public class MancalaTest
{
    public static void main(String[] args)
    {
       MancalaModel model = new MancalaModel(4);
       System.out.println(model.getEndOfTurn());
       model.takeTurn(model.getCurrentPlayer(), 1,3);
       System.out.println(model.getEndOfTurn());
       model.switchPlayer();
       System.out.println(model.getEndOfTurn());
       model.takeTurn(model.getCurrentPlayer(),0,2);
       System.out.println(model.getEndOfTurn());
    }
}
