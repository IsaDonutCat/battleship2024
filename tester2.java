//Isabella Wang
import java.util.Scanner; // input

public class tester2 
{
    public static void main (String[] args)
    {
        int numRow, numCol;
        boolean random; 
        Scanner testerInput = new Scanner(System.in);

        System.out.print("What type of game? (fast/regular)");
        String ans = testerInput.nextLine();

        if (ans.toLowerCase().equals("regular"))
        {
            numRow = 10;
            numCol = 10;
            random = false;
        }    
        else if (ans.toLowerCase().equals("fast"))
        {
            numRow = 8;
            numCol = 8;
            random = true;
        }

        Board gameBoard = new Board(numRow, numCol);

        
    }
}
