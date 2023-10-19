import java.util.Scanner;

public class Board
{
    int numRow, numCol;
    public char grid[][];

    public Board (int r, int c)
    {
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

        System.out.print(" "); //indenting extra. 

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
           
           if (i < numRow - 1)
           {
            for (int k = 0; k < numCol * 2; k++) //accounts for the | lines marking
                System.out.print("-");
           }

           System.out.println();
        }

        return;
    }//closes printboard

    
    /** 
     * @param boat
     * @param inputSource
     */
    public void placePiece(Ship boat, Scanner inputSource)
    {
        String ans = "";
        String orient = "";
        String locs = "";
        int startR = 0;
        int startC = 0;
        int finR = 0;
        int finC = 0;
        int shipSize = boat.getSize(); // save runtime 

        while (!ans.toUpperCase().equals("Y"))
        {
            System.out.println("Place your " + boat.getName() + ". It is " + boat.getSize() + "."); //prints introduction
            System.out.print("First, decide on the orientation (vertical/horizontal):"); // the "do" of the orientation getting
            orient = inputSource.nextLine().toLowerCase(); 

            while (!orient.toLowerCase().equals("vertical") && !orient.toLowerCase().equals("horizontal")) //the while if it is not valid
            {
                System.out.println("The orientation is invalid.");
                System.out.print("First, decide on the orientation (vertical/horizontal):");
                orient = inputSource.nextLine().toLowerCase();
            }

            System.out.print("Please enter in the coordinates of the top left corner of the ship (A1, B1, etc.):"); //finCol and finRow mus be gretaer than that.
            locs = inputSource.nextLine();

            while (boat.inCoords(locs) < 0)
            {
                System.out.print("Please enter in the coordinates of the top left corner of the ship (A1, B1, etc.):"); //finCol and finRow mus be gretaer than that.
                locs = inputSource.nextLine();
            }

            int indexCoords = boat.inCoords(locs);

            startR = (int) locs.toUpperCase().charAt(0) - 65; //cast to int for ease
            startC = Integer.valueOf(locs.substring(indexCoords)) - 1; //cast to integer. the -1 is to acount for the diff between computer counting and human counting
            
            if (orient.equals("vertical"))
            {
                finR = startR + shipSize;
                finC = startC + 1; //the index one greater than where the ship should be, also so it runs at least once
            }
            else
            {
                finR = startR + 1;
                finC = startC + shipSize;
            }


            //this part is the "do" of the positioning "do-while" loop

                while (!boat.placeShip(grid, numRow, numCol, startC, finC, startR, finR, true))
                { 
                    System.out.print("Please enter in the coordinates of the top left corner of the ship (A1, B1, etc.):");
                    locs = inputSource.nextLine();
                    startR = (int) locs.toUpperCase().charAt(0) - 65; //ASCII VALUE FOR 'A'
                    //while (!locs.substring(1).isNumeric())
                    startC = Integer.valueOf(locs.substring(1)) - 1; //fixes to machine counting

                    if (orient.toLowerCase().equals("vertical"))
                    {
                        finR = startR + shipSize;
                        finC = startC + 1; //the index one greater than where the ship should be, also so it runs at least once
                    }
                    else
                    {
                        finR = startR + 1;
                        finC = startC + shipSize;
                    } //updates every loop so it doesn't get trapped
                }


            for (int i = startC; i < finC; i++) // APPARENTLY IT CHECKS THE INITIALIZATION ??? SO I HAVE TO ADD A = SO IT RUNS AT LEAST ONCE
            {
                for (int j = startR; j < finR; j++)
                {
                    if (i == startC && j == startR)
                {
                    if (orient.equals("vertical"))
                        grid[j][i] = '^';
                    else
                        grid[j][i] = '<';
                }
                else if (i == finC - 1 && j == finR - 1)
                {
                    if (orient.equals("vertical"))
                        grid[j][i] = 'v';
                    else
                        grid[j][i] = '>';
                }
                else
                {
                    grid[j][i] = '*';
                }
                }
                
            } //to let player see what their placement looks like
                        printBoard();

            
            System.out.print("Satisfied with the placement of your " + boat.getName() + "? (Y/N)");
            ans = inputSource.nextLine(); //updates

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
                if (x == startC && y == startR)
                {
                    if (orient.equals("vertical"))
                        grid[y][x] = '^';
                    else
                        grid[y][x] = '<';
                }
                else if (x == finC - 1 && y == finR - 1)
                {
                    if (orient.equals("vertical"))
                        grid[y][x] = 'v';
                    else
                        grid[y][x] = '>';
                }
                else
                {
                    grid[y][x] = '*';
                }
            }
        } //actually updates the board
        return;
    }


    
    /** 
     * @param boat
     */
    public void ranPiece(Ship boat)
    {   
        int orientated, ranCol, ranRow, ranRig, ranBot;
        do
        {
         orientated = (int) Math.random() * 2;
         ranCol = (int) Math.random() * numCol;
         ranRow = (int) Math.random() * numRow;

         if (orientated == 0)
            {
                ranRig = ranRow + boat.getSize();
                ranBot = ranCol + 1; //the index one greater than where the ship should be, also so it runs at least once
            }
            else
            {
                ranRig = ranRow + 1;
                ranBot = ranCol + boat.getSize();
            }
            
        }
        while (!boat.placeShip(grid, numRow, numCol, ranCol, ranBot, ranRow, ranRig, false));

        for (int x = ranCol; x < ranBot; x++)
        {
            for (int y = ranRow; y < ranRig; y++)
            {   
                if (x == ranCol && y == ranRow)
                {
                    if (orientated == 0)
                        grid[y][x] = '^';
                    else
                        grid[y][x] = '<';
                }
                else if (x == ranBot - 1 && y == ranRig - 1)
                {
                    if (orientated == 0)
                        grid[y][x] = 'v';
                    else
                        grid[y][x] = '>';
                }
                else
                {
                    grid[y][x] = '*';
                }
            }
        }

        return;
    }

    public void guessWinner (Board answers)
    {
        for (int zzz = 0; zzz < numRow; zzz++)
        {
            for (int xxx = 0; xxx < numCol; xxx++)
            {
                if (answers.grid[zzz][xxx] != 'O' && this.grid[zzz][xxx] != 'X')
                {
                    System.out.println("Player 1 wins");
                    return;
                }
            }

            
        }
        System.out.println("Player 2 wins");
            return;
    }
}//closes class