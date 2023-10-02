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

    public void placeShip(String shipName, int shipSize)
    {   
        Scanner placer = new Scanner(System.in);
        String ans = "";
        int locR, locC, orient;

        if (gameplay) //regular gameplay is longer code
        {
            while (ans != "Y") //since ans was initialized with null, will basically functionas a do while
            {
                System.out.print("Place your " + shipName + ". (" + shipSize + " units). First, type the orientation of your ship (horizontal/vertical):"); 
                ans = placer.nextLine();
                
                

                System.out.print("Finished placing? (Y/N)");
                ans = placer.nextLine();
            }
       }
        }
        else //Math.random
        {

        }
        
        placer.close(); //close scanner input
        return;
    }

}//closes class