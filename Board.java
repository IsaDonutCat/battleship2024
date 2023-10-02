public class Board
{
    int numRow, numCol;
    char grid[][];

    public Board (int r, int c)
    {
        numRow = r;
        numCol = c; // reduces need to continually pass on variables

        grid = new char[r][c];

        for (int i = 0; i < numRow; i++)
        {
            for (int j = 0; j < numCol; j++)
                grid[i][j] = ' '; //nulls stuff out
        }

        printBoard();
    }//closes constructor

    public void printBoard() // prints board. should run everytime the board is changed so user knows what's going on
    {
        for (int i = 0; i < numRow; i++)
        {

            for (int j = 0; j < numRow; j++)
            {
                System.out.print(grid[i][j]);
                if (j != numRow - 1) // if not on the last item
                {
                    System.out.print("|");
                }
            }
            System.out.println();

            
            if (i != numRow - 1)
            {
                for (int j = 0; j < numRow; j++)
                {
                    System.out.print("-");
                }
            } // adds line spacing
            System.out.println();
        }

        return;
    }//closes printboard

}//closes class