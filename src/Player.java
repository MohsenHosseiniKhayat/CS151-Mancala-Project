import java.util.Arrays;

/**
 * Created by Mohsen Hosseini Khayat on 4/14/2017.
 */
public class Player
{
    private int _undoCounter = 0;
    private int[] _pits;
    private boolean _canUndo;
    private int _mancalaStones = 0;
    private int _row;

    /**
     * Constructs a player
     */
    public Player (int row)
    {
        _row = row;
        _canUndo = false;
    }

    /**
     * Checks to see if the player's side of the board is empty
     * Helps determine GameState
     * @return True if their side is empty, false if not empty
     */
    public boolean sideIsEmpty ()
    {
        boolean result = false;
        int stones = 0;
        for (int i = 0; i<_pits.length-1; i++)
        {
            stones += _pits[i];
        }

        if (stones == 0)
        {
            result = true;
        }
        return result;
    }

    /**
     * Allows the association of a side to a player
     * @param row The row of the board we want to associate
     * @param mancalaBoard The game board
     */
    public void setSide (int row, int [][] mancalaBoard)
    {
        _pits = mancalaBoard[row];
        _mancalaStones = mancalaBoard[row][6];
    }

    /**
     * Increments the undo Counter
     */
    public void incrementUndoCounter ()
    {
        _undoCounter++;
    }

    /**
     * Adds or takes stones from mancala
     * @param x The number of stones to add or subtract
     */
    public void addToMancala (int x)
    {
        _mancalaStones = _mancalaStones + x;
    }

    /**
     * Sets the undo counter, mainly used for resetting the undo counter after a turn
     * @param x The number to set the counter to
     */
    public void setUndoCounter (int x)
    {
        _undoCounter = x;
    }

    /**
     * Copies the array into players side of the board
     * @param array The array to copy from
     */
    public void setPits (int [] array)
    {
        for (int i = 0; i<_pits.length; i++)
        {
            _pits = Arrays.copyOf(array,array.length);
        }
    }

    /**
     * Sets the u
     * @param flag
     */
    public void setCanUndo (boolean flag)
    {
        _canUndo = flag;
    }

    /**
     * Sets the stones in the Mancala to a given amount
     * @param x The amount to set the Mancala stones to.
     */
    public void setMancalaStones (int x)
    {
        _mancalaStones = x;
    }

    public int getRow ()
    {
        return _row;
    }

    /**
     * Returns the player's Undo Counter
     * @return _undoCounter The players undo counter
     */
    public int getUndoCounter ()
    {
        return _undoCounter;
    }

    /**
     * Returns the number of stones in the players Mancala
     * @return _MancalaStones The number of stones in the player's Mancala
     */
    public int getMancalaStones ()
    {
        return _mancalaStones;
    }

    /**
     * Returns the array representing the player's side of the board
     * @return _pits, The pits on the players side of the board
     */
    public int [] getSide ()
    {
        return _pits;
    }

    /**
     * Checks to see if player can undo
     * @return True if they can, false if they cant
     */
    public boolean canPlayerUndo ()
    {
        return _canUndo;
    }

    public int getNumStonesOnSide ()
    {
        int remainingStones = 0;
        for (int i = 0; i<6; i++)
        {
            remainingStones += _pits[i];
        }
        return remainingStones;
    }
}