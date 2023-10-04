public class Ship 
{
    int colUno, colFin, rowUno, rowFin, size;
    String name;
    char[][] gameCard;
    public Ship (int shipSize, String title)
    {
        name = title;
        size = shipSize;
    }

    public boolean placeShip (char[][] board, int fircol, int fincol, int firrow, int finrow)
    {

        colUno = fircol;
        colFin = fincol;
        rowUno = firrow;
        rowFin = finrow;
        gameCard = board;

        for (int i = fircol; i < fincol; i++)
        {
            for (int j = firrow; j < finrow; j++)
            {
                if (board[j][i] != 'o')
                    return false;
            }
        }

        for (int i = fircol; i < fincol; i++)
        {
            for (int j = firrow; j < finrow; j++)
            {
                board[j][i] = '*';
            }
        }

        return true;
    }

    public int getSize()
    {
        return size;
    }

    public String getName()
    {
        return name;
    }
}