import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Mohsen Hosseini Khayat on 4/7/2017.
 */
public class MancalaModel
{
    private int[][] _mancalaBoard;
    private Player  _currentPlayer;
    private int[][] _previousBoard;
    private boolean _endOfTurn = false;
    private Player  _playerA = new Player(1);
    private Player  _playerB = new Player(0);
    private GameState _gameState = GameState.gameInProgress;
    //private MancalaPit [][] _mancalaPits;
    private int _numOfStones;
    private ArrayList<ChangeListener> listeners;

    /**
     * Sets up a Mancala model
     *
     * @param numberOfStones The number of stones in each
     *                       pit at the start of the game.
     */
    public MancalaModel(int numberOfStones)
    {
        _numOfStones = numberOfStones;  //To track the number of stones we set the game with. For reset purposes
        listeners = new ArrayList<ChangeListener>();
        
        //Set the current player to player A
        _currentPlayer = _playerA;

        // 2 Rows, one for each player, 7 pits in each row
        //Note: The last element of each row is reserved for the players Mancalas
        _mancalaBoard = new int[2][7];
        _previousBoard = new int[2][7];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                //Fill each pit with the numberOfStones
                _mancalaBoard[i][j] = _numOfStones;
            }
        }

        //Clear out Player A & B's Mancalas
        _mancalaBoard[0][6] = 0;            // Player B's Mancala
        _mancalaBoard[1][6] = 0;            //Player A's Mancala

        //Allocate the board sides to the corresponding players
        _playerA.setSide(_playerA.getRow(),_mancalaBoard);
        _playerB.setSide(_playerB.getRow(),_mancalaBoard);
    }

    /**
     * Current player takes their turn
     * @param row The starting row index of the turn
     * @param column The starting column index of the turn
     */
    public void takeTurn(Player player,int row, int column)
    {
        traverseBoard(row, column);
        // Flip flag to signal end of turn;
        _endOfTurn = !_endOfTurn;
        //Let the current player undo
        if (_endOfTurn)
        {
            player.setCanUndo(true);
        }
        notifyPits();
        _playerA.setSide(_playerA.getRow(),_mancalaBoard);
        _playerB.setSide(_playerB.getRow(),_mancalaBoard);
        //TODO CHANGE PLAYERS
        // I think we need to call switchPlayers() after the player clicks the End turn button
        // which would set the _currentPlayer to the other player

    }

    /**
     * Traverse the board from the given starting position
     * @param row The starting row index
     * @param column The starting column index
     */
    private void traverseBoard(int row, int column)
    {
        //Must check to see if starting move is valid
        if (!firstMoveIsValid(row))
        {
            return;
        }

        //Stones in the starting pit, aka stones to be distributed
        int stonesInHand = _mancalaBoard[row][column];
        //Save the state of the board before this turn
        copyBoardFromTo(_mancalaBoard,_previousBoard);
        //Player cannot start their turn in an empty pit
        //Player cannot move anything from the mancalas
        if (stonesInHand == 0 || row == 6)
        {
            return;
        }

        if (_currentPlayer == _playerA)
        {
            playerATurn(row, column, stonesInHand);
        }
        if (_currentPlayer == _playerB)
        {
            playerBTurn(row, column, stonesInHand);
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
                column = -1;
                stonesPickedUp--;
                if (getTotalStonesCount() + stonesPickedUp != 36)
                {
                    System.out.println("Code 1");
                }
            }

            //Player passes opponent's Mancala, skip it
            else if ( column == 6 && row == 1)
            {
                row = 0;
                column = 0;
                if (getTotalStonesCount() + stonesPickedUp != 36)
                {
                    System.out.println("Code 2");
                }
            }

            //Non mancala pit, drop a stone and continue
            else
            {
               _mancalaBoard[row][column]++;
               stonesPickedUp--;
                if (getTotalStonesCount()+ stonesPickedUp != 36)
                {
                    System.out.println("Code 3");
                }
            }
        }


        //Mancala was last position
        //Bad coding most likely, but we do this check instead of checking for column == 6 because we
        // manipulate the column and row values in that case (check above)
        if (column == -1)
        {
            //get another turn
            _endOfTurn = true;
            if (getTotalStonesCount()+ stonesPickedUp != 36)
            {
                System.out.println("Code 4");
            }
            _currentPlayer.setCanUndo(true);
            notifyPits();
            return;
        }

        //If there is only one stone in the pit
        else if (_mancalaBoard[row][column] == 1 && row == 0)
        {
            _mancalaBoard[row][column] = 0;
            stonesPickedUp = 1 + _mancalaBoard[row+1][5-column];
            //Pick up the one stone and the stones of the opposite pit
            //and drop them in player B's Mancala
            _mancalaBoard[row+1][5-column] = 0;
            _mancalaBoard[0][6] += stonesPickedUp;
            stonesPickedUp = 0;
            if (getTotalStonesCount() + stonesPickedUp!= 36)
            {
                System.out.println("Code 5");
            }
        }

        /*Pit is not empty, pick up stones inside and continue
        else if (_mancalaBoard[row][column]>1)
        {                                                                   //This rule is not in the requirements of this project.
            traverseBoard(row,column);
        }*/
        notifyPits();
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
                column= -1;
                stonesPickedUp--;
                if (getTotalStonesCount() + stonesPickedUp!= 36)
                {
                    System.out.println("Code 6");
                }
            }

            //Player A is passing over opponents Mancala, skips over it
            else if (column == 6 && row == 0)
            {
                //Cycle to the row below
                column = 0;
                row = 1;
                if (getTotalStonesCount()+ stonesPickedUp != 36)
                {
                    System.out.println("Code 7");
                }
            }

            //Passing over a non mancala pit
            else
            {
                //Drop a stone and move on
                _mancalaBoard[row][column]++;
                stonesPickedUp--;
                if (getTotalStonesCount()+ stonesPickedUp != 36)
                {
                    System.out.println("Code 8");
                }
            }
        }

        //Mancala was last position
        //Bad coding most likely, but we do this check instead of checking for column == 6 because we
        // manipulate the column and row values in that case (check above)
        if (column == -1)
        {
            //Player gets to have another turn
            _endOfTurn = true;
            if (getTotalStonesCount()+ stonesPickedUp != 36)
            {
                System.out.println("Code 9");
            }
            _currentPlayer.setCanUndo(true);
            notifyPits();
            return;

        }

        //Last stone was placed into an empty pit
        // on the players own side
        else if (_mancalaBoard[row][column] == 1 && row == 1)
        {
            //Pick the last stone and all the stones
            // on the opposite side of that pit and place them into
            // players Mancala
            _mancalaBoard[row][column] = 0;
            stonesPickedUp = 1 + _mancalaBoard[row - 1][5-column];
            _mancalaBoard[row - 1][5-column] = 0;
            _mancalaBoard[1][6] += stonesPickedUp;
            stonesPickedUp = 0;
            if (getTotalStonesCount()+ stonesPickedUp != 36)
            {
                System.out.println("Code 10");
            }

        }

        /*If the pit isnt empty, pick up all its stones and start
         distributing again
        else if (_mancalaBoard[row][column] > 1)
        {                                                           //This rule is not in the project requirements
            traverseBoard(row, column);
        }*/
        notifyPits();
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
        if (_currentPlayer == _playerA && rowIndex == 1)
        {
            //Player A is starting his/her turn in their respective pits
            result = true;
        }
        else if (_currentPlayer == _playerB && rowIndex == 0)
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
        //Note: Players cant undo more than 3 times in their current turn
        //They can't undo more than one move consecutively
        if (_currentPlayer == _playerA && _currentPlayer.getUndoCounter() <3 )
        {
            copyBoardFromTo(_previousBoard,_mancalaBoard);
            _playerA.incrementUndoCounter();
            _playerA.setCanUndo(false);
            _endOfTurn = false;
        }
        else if (_currentPlayer == _playerB && _currentPlayer.getUndoCounter() < 3)
        {
            copyBoardFromTo(_previousBoard,_mancalaBoard);
            _playerB.incrementUndoCounter();
            _playerB.setCanUndo(false);
            _endOfTurn = false;
        }
        notifyPits();
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

    /**
     * Returns current board
     * @return  _mancalaBoard current board
     */
    public int [][] getMancalaBoard ()
    {
        return _mancalaBoard;
    }

    /**
     * Returns board before most recent turn
     * @return _previousBoard previous board
     */
    public int [][] getPreviousBoard ()
    {
        return _previousBoard;
    }

    /**
     * Return the player whose turn it is
     * @return _currentPlayer The current Player
     */
    public Player getCurrentPlayer ()
    {
        return _currentPlayer;
    }

    /**
     * Set the current player
     * @param player The player whose turn it will be
     */
    public void setCurrentPlayer (Player player) { _currentPlayer = player;}

    /**
     * Reports on the state of the game
     * @return state The state of the game can be inProgress, Victory for player A or Victory for player B
     */
    public boolean hasGameFinished ()
    {
        boolean result = false;
        if (_playerA.sideIsEmpty() || _playerB.sideIsEmpty())
        {
            int [][] endGame;
            if (_playerA.sideIsEmpty())
            {
                _playerB.addToMancala(_playerB.getNumStonesOnSide());
                 endGame = new int[][]{{0, 0, 0, 0, 0, 0, _playerB.getMancalaStones()}, {0, 0, 0, 0, 0, 0, _playerA.getMancalaStones()}};
                 copyBoardFromTo(endGame,_mancalaBoard);
            }
            if (_playerB.sideIsEmpty())
            {
                _playerA.addToMancala(_playerA.getNumStonesOnSide());
                endGame = new int[][]{{0, 0, 0, 0, 0, 0, _playerB.getMancalaStones()}, {0, 0, 0, 0, 0, 0, _playerA.getMancalaStones()}};
                copyBoardFromTo(endGame,_mancalaBoard);
            }
            if (_playerA.getMancalaStones() > _playerB.getMancalaStones())
            {
                result = true;
                _gameState = GameState.playerAWon;

            }
            else
            {
                result = true;
                _gameState = GameState.playerBWon;
            }
        }
        return result;
    }

    /**
     * Prints the board, for testing purposes
     */
    public void printBoard ()
    {
        String result = "";
        for (int i = 0; i<_mancalaBoard[0].length; i++)
        {
            result += _mancalaBoard[0][i] + " ";
        }
        result += "\n";
        for (int i = 0; i<_mancalaBoard[0].length; i++)
        {
            result += (i) + " ";
        }
        result += "\n";
        for (int i = 0; i<_mancalaBoard[0].length; i++)
        {
            result += _mancalaBoard[1][i] + " ";
        }

        System.out.println(result);
    }

    /**
     * Returns the game state
     * @return _gameState The state of the game
     */
    public GameState getGameState ()
    {
        return _gameState;
    }

    /**
     * Hands over control to the other player
     */
    public void switchPlayer ()
    {
        String str = "";
        if (_currentPlayer == _playerA)
        {
            //Reset their undo flag so they wont be able to immediately undo on their following turn
            _currentPlayer.setCanUndo(false);
            _playerB.setCanUndo(false);
            _currentPlayer.setUndoCounter(0);

            //Then change the player
            _currentPlayer = _playerB;
            str = "Player B's turn";
            _endOfTurn = false;
            notifyPits();
        }
        else
        {
            //Reset their undo flag so they wont be able to immediately undo on their following turn
            _currentPlayer.setCanUndo(false);
            _playerA.setCanUndo(false);
            _currentPlayer.setUndoCounter(0);

            //Then change the player
            _currentPlayer = _playerA;
            str = "Player A's turn";
            _endOfTurn = false;
            notifyPits();
        }

        System.out.println("Player changed: "  + str);
    }

    /**
     * Resets the board state for a new game
     */
    public void resetBoard ()
    {
        int a = _numOfStones;
        //Reset the board arrays
        int[][] newBoard = {{a,a,a,a,a,a,0},{a,a,a,a,a,a,0}} ;
        _currentPlayer = _playerA;
        _gameState = GameState.gameInProgress;
        
        
        copyBoardFromTo(newBoard,_mancalaBoard);
        copyBoardFromTo(newBoard,_previousBoard);

        //Reset the flags and Mancalas
        _playerA.setMancalaStones(0);
        _playerB.setMancalaStones(0);
        _playerA.setCanUndo(false);
        _playerB.setCanUndo(false);
        _playerA.setUndoCounter(0);
        _playerB.setUndoCounter(0);

        //Must notify observers
        //notifyPits();
    }

    /**
     * Adds a pit listener for the corresponding element in the board
     * @param cl The listener to add
     */
    public void attach(ChangeListener cl)
    {
        listeners.add(cl);
    }

    /**
     * Updates observers
     */
    public void notifyPits ()
    {
        for(ChangeListener cl : listeners)
        {
        	cl.stateChanged(new ChangeEvent(this));
        }
    }

    /**
     * Sets the end of turn status
     * @param ended The new status
     */
    public void setEndOfTurn (boolean ended)
    {
        _endOfTurn = ended;
    }

    /**
     * Returns the end of turn status
     * @return True if turn ended, false otherwise
     */
    public boolean getEndOfTurn () {return _endOfTurn;}
    
    public String toString()
    {
    	String boardString = "\n   ";
    	for(int i = 5; i >= 0; i--)
    	{
    		boardString += "[" + _mancalaBoard[0][i] + "]";
    	}
    	
    	boardString += "\n[" + _mancalaBoard[0][6] 
    			+ "]" + "                  "
    			+ "[" + _mancalaBoard[1][6] + "]\n B ";
    	
    	for(int i = 0; i <= 5; i++)
    	{
    		boardString += "[" + _mancalaBoard[1][i] + "]";
    	}
    	boardString += " A \n";
    	return boardString;
    }

    public int getTotalStonesCount ()
    {
        int result = 0;
        for (int i = 0; i<2; i++)
        {
            for (int j = 0; j<7; j++)
            {
                result += _mancalaBoard[i][j];
            }
        }
        return result;
    }
}