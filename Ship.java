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
        gridRows = rowNumb;
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

    public int inCoords (String ans) //return -1 if coords don't work, return index where vertical start
    {
        char[] arr = ans.toCharArray();
        int len = arr.length;

        int  index = 0;
        if (len < 1)
        {
            System.out.println("Please enter an actual guess");
            return -4;
        }

        if (!Character.isLetter(arr[0]))
        {
            System.out.println("No row coordinate found.");
            return -1;
        }

        while (Character.isAlphabetic(arr[index]))
        {
            index++;
            if(index >= len)
            {
                System.out.println("No column coordinate found.");
                return -2;
            }
        }

        int cursor = index;

        while (cursor < len) //makes sure parse int won't have error
        {
            if (!Character.isDigit(arr[cursor]))
            {
                System.out.println("Invalid column coordinate");
                return -3;
            }
            cursor++;
        }
        return index;
    }


}