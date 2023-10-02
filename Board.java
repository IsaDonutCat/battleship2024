import java.util.Scanner;

public class Board
{
    int numRows =10;
    int numCols =10;

    //int[][] gameBoard = new int[numRows][numCols];
    int[][] gameBoard;
 
    public Board (int c, int r)
    {
        numRows = r;
        numCols = c;

        int[][] gameBoard = new int[r][c];

        for (int a = 0; a < numRows; a++)
        {
            for(int b = 0; b < numCols; b++)
                gameBoard[a][b] = 0;
        }
    }



    public void printBoard()
    {   

        for (int a = 0; a <= numRows-1; a++)
        {
                for (int b = 0; b <= numCols-1; b++)
                {
                        System.out.print(gameBoard[a][b]);
                }
            System.out.print("\n");  //new line char
        }
    }

    public void placeShip(String shipName, int shipSize)
    {   
        Scanner shipInput = new Scanner(System.in);

        
        String ans = "";
        int r,c,orient,loop;

        while (ans != "Y")
        {
            System.out.println("XXX\n XXX");
            System.out.println("Place your " +  shipName + ". Uppercase Letter/Number/Degrees will be the left corner:");

            ans = shipInput.nextLine(); 
            r = (int) ans.charAt(0) - 65; // ascii value of A
            c = Integer.valueOf(ans.substring(ans.indexOf("/") + 1, ans.lastIndexOf("/") )) - 1; // the plus one is we don't want, the minus accounts for diff between human and computer counting
            orient = Integer.valueOf(ans.substring(ans.lastIndexOf("/")+1,ans.length())); //setting values;
            loop = 0;

            if (orient % 90 != 0 )
                System.out.println("Impossible orientation. Orientation must be in right angles");
            else
            {
                if ((orient / 90) % 2 == 0)
                {
                    if (c > numCols || r + shipSize > numRows)
                        System.out.print("Ship is off the board. The number of rows is " + numRows + " and the number of columns is " + numCols);
                    else
                    {
                        while (loop < shipSize)
                        {
                            if (gameBoard[r+loop][c] == 0)
                                gameBoard[r + loop][c] = 1;
                            else
                            {
                                System.out.print("A ship is already there.");
                                break;
                            }
                            loop++;
                        }
                        loop = 0;
                    }
                }
                else
                {
                    if (c + shipSize > numCols || r > numRows)
                        System.out.print("Ship is off the board. The number of rows is " + numRows + " and the number of columns is " + numCols);
                    else
                    {
                        while (loop < shipSize)
                        {
                            if (gameBoard[r][c + loop] == 0)
                                gameBoard[r][c + loop] = 1;
                            else
                            {
                                System.out.print("A ship is already there.");
                                break;
                            }
                            loop++;
                        }
                        loop = 0;
                    }
                }
            }

        }//end of while loop
        printBoard();
        shipInput.close();
    }//end of printShip method

}// end o class file