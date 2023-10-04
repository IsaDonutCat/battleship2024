//Isabella Wang
import java.util.Scanner; // input

public class Tester 
{
    public static void main (String[] args)
    {
        int numRow, numCol;
        boolean random; 
        Scanner testerInput = new Scanner(System.in);

        System.out.print("What type of game? (fast/regular)");
        String ans = testerInput.nextLine(); 

        while (!ans.toLowerCase().equals("fast") && !ans.toLowerCase().equals("regular"))
        {
            System.out.println("Unaccepted type of battleship game.");
            System.out.print("What type of game? (fast/regular)");
            ans = testerInput.nextLine(); 
        }

        if (ans.toLowerCase().equals("regular")) //sets down the rules of the game and which will apply
        {
            numRow = 10;
            numCol = 10;
            random = false;
        }    
        else
        {
            numRow = 8;
            numCol = 8;
            random = true;
        }

        Board gameBoard = new Board(numRow, numCol, random);
        testerInput.close();

    }
}
