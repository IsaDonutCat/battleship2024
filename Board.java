public class Board
{
    int numRow, numCol;
    char grid[][];

    public Board (int r, int c)
    {
        numRow = r;
        numCol = c; // reduces need to continually pass on variables

        grid = new char[r][c];

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
                grid[i][j] = ' '; //nulls stuff out
        }
    }
}