public class Ship 
{
    int colUno, colFin, rowUno, rowFin, size, gridRows, gridCols;
    String name;
    char[][] gameCard;

    public Ship (int shipSize, String title) // constructor
    {
        name = title;
        size = shipSize;
    }

    public int getSize() // getters. useful
    {
        return size;
    }

    public String getName()  //getters . just to be fancy
    {
        return name;
    }

    public boolean placeShip (char[][] board, int rowNumb, int colNumb, int fircol, int fincol, int firrow, int finrow) //this many just to avoid the need for more variables later.
    {
        gridRows = (rowNumb);
        gridCols = colNumb;
        colUno = fircol;
        colFin = fincol;
        rowUno = firrow;
        rowFin = finrow;
        gameCard = board;

        if (rowFin > gridRows || colFin > gridCols
        || firrow < 0 || fircol < 0)
        {
            System.out.println("The ship would be hanging off the board.");
            return false;
        }

        for (int i = fircol; i < fincol; i++)
        {
            for (int j = firrow; j < finrow; j++)
            {
                if (board[j][i] != 'O')
                {
                    System.out.println("Another ship is occupying this space!");
                    return false;
                }
            }
        }

        return true;
    }

    


}