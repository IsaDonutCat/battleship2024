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
                grid[i][j] = 'O'; //nulls stuff out
        }

        printBoard();
    }//closes constructor




    public void printBoard() // prints board. should run everytime the board is changed so user knows what's going on
    {
        char letter = 65; //ASCII value for 'A'
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
           for (int k = 0; k < numCol * 2; k++) //accounts for the | lines marking
            System.out.print("-");

           System.out.println();
        }

        return;
    }//closes printboard

    public boolean placePiece(Ship boat)
    {
        Scanner boardInput = new Scanner(System.in);
        String ans = "";
        String orient = "";
        String locs = "";
        int startR = 0;
        int startC = 0;
        int finR = 0;
        int finC = 0;
        int shipSize = boat.getSize();

        while (!ans.toUpperCase().equals("Y"))
        {
            System.out.println("Place your " + boat.getName() + ". It is " + boat.getSize() + "."); //prints introduction
            System.out.print("First, decide on the orientation (vertical/horizontal):"); // the "do" of the orientation getting
            orient = boardInput.nextLine(); 

            while (!orient.toLowerCase().equals("vertical") && !orient.toLowerCase().equals("horizontal")) //the while if it is not valid
            {
                System.out.println("The orientation is invalid. Please make sure to type in lowercase.");
                System.out.print("First, decide on the orientation (vertical/horizontal):");
                orient = boardInput.nextLine();
            }

            System.out.print("Please enter in the coordinates of the top left corner of the ship (A1, B1, etc.):"); //finCol and finRow mus be gretaer than that.
            locs = boardInput.nextLine();
            startR = (int) locs.toUpperCase().charAt(0) - 65; //cast to int for ease
            startC = Integer.valueOf(locs.substring(1)) - 1; //cast to integer. the -1 is to acount for the diff between computer counting and human counting

            if (orient.toLowerCase().equals("vertical"))
            {
                finR = startR + shipSize; //using getter to not touch the variable
                finC = startC; 
            }
            else 
            {
                finR = startR; //added on 
                finC = startC + shipSize;
            }
            //this part is the "do" of the positioning "do-while" loop

                while (!boat.placeShip(grid, numRow, numCol, startC, finC, startR, finR))
                { 
                    System.out.print("Please enter in the coordinates of the top left corner of the ship (A1, B1, etc.):");
                    locs = boardInput.nextLine();
                    startR = (int) locs.toUpperCase().charAt(0) - 65; //ASCII VALUE FOR 'A'
                    startC = Integer.valueOf(locs.substring(1)) - 1; //fixes to machine counting

                    if (orient.toLowerCase().equals("vertical"))
                    {
                        finR = startR + shipSize; //using getter to not touch the variable
                        finC = startC; 
                    }
                    else 
                    {
                        finR = startR; //added on 
                        finC = startC + shipSize; //this is why i got mixed up. if it's vetical, the number of rows is changing, but horizontal means number of columns is changing
                    }
                }


            for (int i = startC; i <= finC; i++) // APPARENTLY IT CHECKS THE INITIALIZATION ??? SO I HAVE TO ADD A = SO IT RUNS AT LEAST ONCE
            {
                System.out.println(i);
                for (int j = startR; j <= finR; j++)
                {
                    grid[j][i] = '*';
                }
                
            } //to let player see what their placement looks like
            printBoard();

            
            System.out.print("Satisfied with the placement of your " +boat.getName() + "? (Y/N)");
            ans = boardInput.nextLine(); //updates

            if (!ans.toUpperCase().equals("Y"));
            {
                for (int i = startC; i < finC; i++)
                {
                    for (int j = startR; j < finR; j++)
                    {
                        grid[j][i] = 'O';
                    }
                }
            }//clears the board if they don't like it

        }//close of while loop returning

        for (int x = startC; x < finC; x++)
        {
            for (int y = startR; y < finR; y++)
            {
                grid[y][x] = '*';
            }
        } //actually updates the board

        boardInput.close();
        return true;
    }

}//closes class