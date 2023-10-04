//Isabella Wang
import java.util.Scanner; // input
import java.util.Arrays;

public class Tester 
{
    public static void main (String[] args)
    {
        int numRow, numCol;
        boolean random; 
        Scanner testerInput = new Scanner(System.in);
        System.out.print("What type of game? (fast/regular)");
        String ans = testerInput.nextLine(); 
        Ship[] shipSet = { new Ship(2,"PT Boat"), new Ship(3,"Submarine"), 
            new Ship(3,"Destroyer"), new Ship(4,"Battleship"), new Ship(5, "Carrier") };
        while (!ans.toLowerCase().equals("fast") && !ans.toLowerCase().equals("regular"))
        {
            System.out.println("Invalid type of battleship game.");
            System.out.print("What type of game? (fast/regular)");
            ans = testerInput.nextLine(); 
        }

        if (ans.toLowerCase().equals("regular")) //sets down the rules of the game and which will apply
        {
            numRow = 10;
            numCol = 10;;
            random = false;
        }    
        else
        {
            numRow = 8;
            numCol = 8;
            shipSet = Arrays.copyOfRange(shipSet,2,5);
            random = true;
        }

        Board gameBoard = new Board(numRow, numCol, random); //med tp create a random ship set class

        int len = shipSet.length;

        for (int i = 0; i < len; i++)
        {
            if (!random)
                gameBoard.placePiece(shipSet[i]);
        }
        

        testerInput.close();

    }
}
