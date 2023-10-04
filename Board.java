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
            System.out.print(numerical);

            for (int j = 0; j < numRow; j++)
            {   
                if ( i == 0)
                {   
                    for (int uno = 0; uno < numRow; uno++)
                    {
                        System.out.print(letter);
                        if (j != uno - 1) // if not on the last item
                        {
                        System.out.print("|");
                        }
                        letter++;
                    }

                    System.out.println();
                } /// print out capital letters for rows

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

            numerical++;
        }

        return;
    }//closes printboard

    public boolean placeShip(String shipName, int shipSize)
    {   
        Scanner placer = new Scanner(System.in);
        String ans = "";
        int locR, locC; 
        boolean orient; //true for horizontal, false for vertical

        if (gameplay) //regular gameplay is longer code
        {
            System.out.print("Select an orientation (H/V):");
            ans = placer.nextLine();

            if (!(ans.equals("V") || ans.equals("H")))
            {
                System.out.println();
                placer.close();
                return false;
            }
             
            if (ans.equals("H")) // sets orientation
                orient = true;
            else    
                orient = false;

            System.out.print("Enter row letter (Left Corner):");
            ans = placer.nextLine();
            locR = (int) ans.toCharArray()[0] - 65;

            System.out.print("Enter column number (Left Corner):");
            locC = placer.nextInt()-1;
            
            if ((orient && (locR + shipSize > numRow || locC > numCol)) 
            || (!orient && (locC + shipSize > numCol || locR > numRow))) //returns false if ship would be placed out of bounds
            {
                placer.close();
                return false;
            }

            if (orient)
            {
                for (int loopNum = 0; loopNum < shipSize; loopNum++) //first checks to make sure everything is empty
                {
                    if (grid[locR + loopNum][locC] != 'o')
                        return false;
                }

                for (int loopNum = 0; loopNum < shipSize; loopNum++) //first checks to make sure everything is empty
                {
                    grid[locR + loopNum][locC] = "*";
                }
            }
            else
            {
                for (int loopNum = 0; loopNum < shipSize; loopNum++)
                {
                    if ()
                }
            }
            
            System.out.print("Happy with position? (Y/N)");
            ans = placer.nextLine();

            placer.close(); // final to confirm 
            if (!ans.equals("Y"))
                return false;
            else
                return true;

        }
        else //Math.random
        {

        }
        
        placer.close(); //close scanner input

    }

}//closes class