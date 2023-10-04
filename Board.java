import java.util.Scanner;

public class Board
{
    int numRow, numCol;
    char grid[][];
    boolean gameplay; // true == regular, false == speed
    public Board (int r, int c, boolean style)
    {
        gameplay = style;
        numRow = r;
        numCol = c; // reduces need to continually pass on variables

        grid = new char[r][c];

        for (int i = 0; i < numRow; i++)
        {
            for (int j = 0; j < numCol; j++)
                grid[i][j] = 'o'; //nulls stuff out
        }

        printBoard();
    }//closes constructor




    public void printBoard() // prints board. should run everytime the board is changed so user knows what's going on
    {
        char letter = 65;
        int numerical = 1;

        for (int i = 0; i < numRow; i++)
        {
            System.out.print(" " + numerical); // numerical for columns
            numerical++;
        }

        System.out.println(); //creates new line for the os to take oer

        for (int i = 0; i < numRow; i++)
        {
           System.out.print(letter + " ");
           letter++;
        
           for (int j = 0; j < numCol; j++)
           {
            if (j != 0)
                System.out.print("|");
            System.out.print(grid[i][j]);
           }

           System.out.println(); 
           System.out.print(" ");
           for (int k = 0; k < numCol * 2; k++)
            System.out.print("-");

           System.out.println();
        }

        return;
    }//closes printboard

  public boolean (Ship boat, )
  {
    Scanner boardInput = new Scanner(System.in);

    
  }

}//closes class