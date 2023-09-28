public class Board
{
    int rowNum;
    int colNum;
    char[][] board;
    public Board (int c, int r)
    {
        rowNum = r;
        colNum = c;

        char[][] board = new char [rowNum][colNum];

        for (int a = 0; a < rowNum; a++)
        {
            for(int b = 0; b < colNum; b++)
                board[a][b] = 'O';
        }
    }

    public void print()
    {   
        int rPos = 0;
        int cPos = 0;

        for (int a = 0; a < rowNum * 2; a++)
        {
            if (a % 2 == 0)
            {
                for (int b = 0; b < colNum * 2; b++)
                {
                    if (b % 2 == 0)
                    {
                        System.out.print(board[rPos][cPos]);
                        cPos++;
                    }
                    else
                    {
                        System.out.print("|");
                    }
                }

                rPos++;
            }
            else
            {
                for (int i = 0; i < colNum * 2; i++)
                    System.out.print("_");
            }

            System.out.println();
        }
    }
}