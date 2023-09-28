public class Board
{
    int rowNum;
    int colNum;
    int[][] gameBoard;
    public Board (int c, int r)
    {
        rowNum = r;
        colNum = c;

        int[][] gameBoard = new int[rowNum][colNum];

        for (int a = 0; a < rowNum; a++)
        {
            for(int b = 0; b < colNum; b++)
                gameBoard[a][b] = 0;
        }
    }

    public void print()
    {   
        int rPos = 0;
        int cPos = 0;

        for (int a = 0; a < rowNum * 2; a++)
        {
                for (int b = 0; b < colNum * 2; b++)
                {
                        System.out.print(gameBoard[rPos][cPos]);
                }
            System.out.println();
        }
    }
}