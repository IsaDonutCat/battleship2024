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

    public void placeShip()
    {   
        Scanner shipInput = new Scanner(System.in);

        
        String ans = "";
        int r,c,orient;

        while (ans != "Y")
        {
            System.out.println("XXX\n XXX");
            System.out.println("Place your armored carrier Uppercase Letter/Number/Degrees will be the top left corner:");

            ans = shipInput.nextLine(); 
            r = (int) ans.charAt(0) - 65; // ascii value of A
            c = (int) str.substring(ans.indexOf("/") + 1, ans.lastIndexOf("/")) - 1; // the plus one is we don't want, the minus accounts for diff between human and computer counting
            orient = (int) Integer.valueOf(ans.substring(ans.lastIndexOf("/")+1,ans.length())); //setting values;

            if (orient % 90 != 0 )
                System.out.println("Impossible orientation. Orientation must be in right angles");
            else if (r >= numRows || c >= numCols)
        }
    }
}