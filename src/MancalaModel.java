import java.util.Arrays;

/**
 * Created by Mohsen Hosseini Khayat on 4/7/2017.
 */
public class MancalaModel
{
    private int[][] _mancalaBoard;
    private boolean _isPlayerA;
    private boolean _canUndoPlyrA = true;
    private boolean _canUndoPlyrB = true;
    private int _undoCounterA = 0;
    private int _undoCounterB = 0;
    private int[][] _previousBoard;

    /**
     * Sets up a Mancala model
     *
     * @param numberOfStones The number of stones in each
     *                       pit at the start of the game.
     */
    public MancalaModel(int numberOfStones)
    {
        //Set the current player to player A
        _isPlayerA = true;

        // 2 Rows, one for each player, 7 pits in each row
        //Note: The last element of each row is reserved for the players Mancalas
        _mancalaBoard = new int[2][7];
        _previousBoard = new int[2][7];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                //Fill each pit with the numberOfStones
                _mancalaBoard[i][j] = numberOfStones;
            }
        }

        //Clear out Player A & B's Mancalas
        _mancalaBoard[0][6] = 0;            // Player B's Mancala
        _mancalaBoard[1][6] = 0;            //Player A's Mancala
    }

    /**
     * Current player takes their turn
     * @param row The starting row index of the turn
     * @param column The starting column index of the turn
     */
    public void takeTurn(int row, int column)
    {
        traverseBoard(row, column);
        if (_isPlayerA)
        {
            _canUndoPlyrA = true;
        }
        else
        {
            _canUndoPlyrB = true;
        }

        _isPlayerA = !_isPlayerA; //Next players turn
        //After a player finishes their turn, reset the counters so the next player can still undo
        _undoCounterA = 0;
        _undoCounterB = 0;

    }

    /**
     * Traverse the board from the given starting position
     * @param row The starting row index
     * @param column The starting column index
     */
    public void traverseBoard(int row, int column)
    {
        //Must check to see if starting move is valid
        if (!firstMoveIsValid(row))
        {
            return;
        }

        //Stones in the starting pit, aka stones to be distributed
        int stonesPickedUp = _mancalaBoard[row][column];
        //Save the state of the board before this turn
        copyBoardFromTo(_mancalaBoard,_previousBoard);
        //Player cannot start their turn in an empty pit
        //Player cannot move anything from the mancalas
        if (stonesPickedUp == 0 || row == 6)
        {
            return;
        }

        if (_isPlayerA)
        {
            playerATurn(row, column, stonesPickedUp);
        }
        if (!_isPlayerA)
        {
            playerBTurn(row, column, stonesPickedUp);
        }
    }

    /**
     * Player B is the player currently making a move
     * @param row The starting row index
     * @param column The starting column index
     * @param stonesPickedUp The stones the player picks up from the starting pit
     */
    private void playerBTurn(int row, int column, int stonesPickedUp)
    {
        _mancalaBoard[row][column] = 0; //Empty the starting pit
        while (stonesPickedUp >0)
        {
            //Move counter clock wise
            column++;

            //Player passes their own mancala, drop a stone and move on
            if (column == 6 && row == 0)
            {
                _mancalaBoard[row][column]++;
                row = 1;
                column = 0;
                stonesPickedUp--;
            }

            //Player passes opponent's Mancala, skip it
            else if ( column == 6 && row == 1)
            {
                row = 0;
                column = 0;
            }

            //Non mancala pit, drop a stone and continue
            else
            {
               _mancalaBoard[row][column]++;
               stonesPickedUp--;
            }
        }

        //Mancala was last position
        if (column == 6)
        {
            //get another turn
            return;
        }

        //If there is only one stone in the pit
        else if (_mancalaBoard[row][column] == 1)
        {
            _mancalaBoard[row][column] = 0;
            stonesPickedUp = 1 + _mancalaBoard[row+1][column];
            //Pick up the one stone and the stones of the opposite pit
            //and drop them in player B's Mancala
            _mancalaBoard[0][6] = stonesPickedUp;
            stonesPickedUp = 0;

        }

        //Pit is not empty, pick up stones inside and continue
        else if (_mancalaBoard[row][column]>1)
        {
            traverseBoard(row,column);
        }
    }

    /**
     * Player A is the player currently making a move
     * @param row The starting row index
     * @param column The starting column index
     * @param stonesPickedUp The stones the player picks up from the starting pit
     */
    private void playerATurn(int row, int column, int stonesPickedUp)
    {
        _mancalaBoard[row][column] = 0; //Empty the starting point

        while (stonesPickedUp > 0)
        {
            //Move counter clockwise
            column++;

            //Player A is passing over their own Mancala
            if (column == 6 && row == 1)
            {
                //Add one to the Mancala and go to the top rows first pit
                _mancalaBoard[row][column]++;
                row = 0;
                column=0;                               // TODO
                stonesPickedUp--;
            }

            //Player A is passing over opponents Mancala, skips over it
            else if (column == 6 && row == 0)
            {
                //Cycle to the row below
                column = 0;
                row = 1;
            }

            //Passing over a non mancala pit
            else
            {
                //Drop a stone and move on
                _mancalaBoard[row][column]++;
                stonesPickedUp--;
            }
        }

        //Last stone placed is in player's own Mancalaa
        if (column == 6)
        {
            //Player gets to have another turn
            return;
        }

        //Last stone was placed into an empty pit
        // on the players own side
        else if (_mancalaBoard[row][column] == 1)
        {
            //Pick the last stone and all the stones
            // on the oppoiste side of that pit and place them into
            // players Mancala
            _mancalaBoard[row][column] = 0;
            stonesPickedUp = 1 + _mancalaBoard[row - 1][column];
            _mancalaBoard[1][6] = stonesPickedUp;
            stonesPickedUp = 0;
        }

        //If the pit isnt empty, pick up all its stones and start
        // distributing again
        else if (_mancalaBoard[row][column] > 1)
        {
            traverseBoard(row, column);
        }
    }

    /**
     * Evaluates the validity of the players opening move on their turn
     * @param rowIndex The row of the pit the move is starting from
     * @return Result True if the move is valid, false if otherwise.
     */
    public boolean firstMoveIsValid (int rowIndex)
    {
        Boolean result = false;
        //Note: Remember row #2 (index =1 ) is players A side of the board
        if (_isPlayerA && rowIndex == 1)
        {
            //Player A is starting his/her turn in their respective pits
            result = true;
        }
        else if (!_isPlayerA && rowIndex == 0)
        {
            //Player B is starting his/her turn in their respective pits
            result = true;
        }
        else
        {
            result = false;
        }

        return result;
    }

    /**
     * Undo the current players last turn
     */
    public void undoLastMove ()
    {
        //Note: Players cant undo more than 3 times per turn
        //They can't undo more than one move
        if (_isPlayerA && _undoCounterA <3 )
        {
            copyBoardFromTo(_previousBoard,_mancalaBoard);
            _undoCounterA++;
            _canUndoPlyrA = false;
        }
        else if (!_isPlayerA && _undoCounterB < 3)
        {
            copyBoardFromTo(_previousBoard,_mancalaBoard);
            _undoCounterB++;
            _canUndoPlyrB = false;
        }
    }

    /**
     * Copys board  from -> to, allows saving of board state and undoing
     * @param from The array to copy from
     * @param to The array to copy to
     */
    public void copyBoardFromTo (int [][] from, int [][] to)
    {
        for (int i = 0; i< from.length; i++)
        {
            to[i] = Arrays.copyOf(from[i],from[i].length);
        }
    }

    /**
     * Returns the number of stones in a given pit
     * @param i Row
     * @param j Column
     * @return The number of stones in given pit
     */
    public int getStonesAtPit (int i, int j)
    {
        return _mancalaBoard[i][j];
    }
}
