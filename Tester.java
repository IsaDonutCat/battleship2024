//Isabella Wang
import java.util.Scanner; // input
import java.util.Arrays;
public class Tester 
{
    private static Scanner inputSource = new Scanner(System.in);

    public static void main (String[] args)
    {
        int numRow, numCol;
        boolean randomized; 
        System.out.print("What type of game? (fast/regular)");
        String ans = inputSource.nextLine(); 
        Ship[] shipSet = { new Ship(2,"PT Boat"), new Ship(3,"Submarine"), 
            new Ship(3,"Destroyer"), new Ship(4,"Battleship"), new Ship(5, "Carrier") };

        while (!ans.toLowerCase().equals("fast") && !ans.toLowerCase().equals("regular"))
        {
            System.out.println("Invalid type of battleship game.");
            System.out.print("What type of game? (fast/regular)");
            ans = inputSource.nextLine(); 
        }

        if (ans.toLowerCase().equals("regular")) //sets down the rules of the game and which will apply
        {
            numRow = 10;
            numCol = 10;;
            randomized = false;
            /*System.out.println("Welcome to regular mode!");
            System.out.println("In this mode, player 1 will place 5 ships: a PT Boat (2 units long), a submarine (3 units long),\na destroyer (3 units long), a battleship (4 units long), and a carrier (5 units long).  ");
            System.out.println("Then, player 2 will have a given number of guesses. An 'O' will represent an unknown location,\na '.' will represent a miss, a '!' will represent a hit and a 'x' will represent a sunk ship.");
            System.out.println("If player 2 manages to sink all the ships in the given number of guesses, player 2 will win. Otherwise, player 1 will win.");*/
        }    
        else
        {
            numRow = 8;
            numCol = 8;
            shipSet = Arrays.copyOfRange(shipSet,2,5);
            randomized = true;
            /*System.out.println("Welcome to fast mode!");
            System.out.println("In this mode, the computer will place 3 ships: a submarine (3 units long), a battleship (4 units long), and a carrier (5 units long).  ");
            System.out.println("Then, you will have 20 guesses. An 'O' will represent an unknown location, \na '.' will represent a miss, a '!' will represent a hit and a 'x' will represent a sunk ship.");
            System.out.println("If you manage to sink all the ships in the given number of guesses, you will win. Otherwise, the computer will win."); //random mode to*/
        }

        Board placeBoard = new Board(numRow, numCol, randomized); //med tp create a random ship set class

        int len = shipSet.length;
        if (!randomized)
        {
            for (int i = 0; i < len; i++)
            {
                    placeBoard.placePiece(shipSet[i], inputSource); 
                    //i give up lets just pass scanner in. also apparently ur not supposed to have multiple scanners or else they'll eat everything. WHOOPS
            }

        }

        inputSource.close(); // at the very end

    }
}
