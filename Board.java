public class Board
{
    int numRows =10;
    int numCols =10;

    //int[][] gameBoard = new int[numRows][numCols];
    int[][] gameBoard;
 
    public Board (int c, int r)
    {
        numRows = r;
        numCols = c;

        int[][] gameBoard = new int[r][c];

        for (int a = 0; a < numRows; a++)
        {
            for(int b = 0; b < numCols; b++)
                gameBoard[a][b] = 2;
        }
    }



    public void printBoard()
    {   

        for (int a = 0; a <= numRows-1; a++)
        {
                for (int b = 0; b <= numCols-1; b++)
                {
                        System.out.print(gameBoard[a][b]);
                }
            System.out.print("\n");  //new line char
        }
    }
}