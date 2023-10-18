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
            System.out.println();
        }

        if (ans.toLowerCase().equals("regular")) //sets down the rules of the game and which will apply
        {
            numRow = 10;
            numCol = 10;;
            randomized = false;
            System.out.println("Welcome to regular mode!");
            System.out.println("In this mode, player 1 will place 5 ships: a PT Boat (2 units long), a submarine (3 units long),\na destroyer (3 units long), a battleship (4 units long), and a carrier (5 units long).  ");
            System.out.println("Then, player 2 will have a given number of guesses. An 'O' will represent an unknown location,\na '.' will represent a miss, a '!' will represent a hit and a 'x' will represent a sunk ship.");
            System.out.println("If player 2 manages to sink all the ships in the given number of guesses, player 2 will win. Otherwise, player 1 will win.");
        }   
        else
        {
            numRow = 8;
            numCol = 8;
            shipSet = Arrays.copyOfRange(shipSet,2,5);
            randomized = true;
            System.out.println("Welcome to fast mode!");
            System.out.println("In this mode, the computer will place 3 ships: a submarine (3 units long), a battleship (4 units long), and a carrier (5 units long).  ");
            System.out.println("Then, you will have 20 guesses. An 'O' will represent an unknown location, \na '.' will represent a miss, a '!' will represent a hit and a 'x' will represent a sunk ship.");
            System.out.println("If you manage to sink all the ships in the given number of guesses, you will win. Otherwise, the computer will win."); //random mode to
        }

        while (!ans.toUpperCase().equals("Y"))
        {
            System.out.print("Are you ready to proceed?");
            ans = inputSource.nextLine();
        }

        Board placeBoard = new Board(numRow, numCol); //med tp create a random ship set class
        Board guessBoard = new Board(numRow,numCol);
        int maxGuesses = 20;
        String trythis;
        int len = shipSet.length;

        if (!randomized)
        {
            for (int i = 0; i < len; i++)
            {
                    placeBoard.placePiece(shipSet[i], inputSource); 
                    //i give up lets just pass scanner in. also apparently ur not supposed to have multiple scanners or else they'll eat everything. WHOOPS
            }
            System.out.print("Number of guesses:");
            maxGuesses = inputSource.nextInt();           
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n"); //clear the screen to reduce cheating
            Shooty guesser = new Shooty(placeBoard, guessBoard, maxGuesses); //WHY WONT U COOPERATE >:(

            trythis = inputSource.nextLine();
            System.out.print("Enter a guess:");
            trythis = inputSource.nextLine();

            while (!guesser.guessThat(trythis))
            {
                System.out.print("Enter a guess:");
                trythis = inputSource.nextLine();
            }
        }
        else
        {
            Ship[] skrunk = Arrays.copyOfRange(shipSet, 0, 3);
            for (Ship x : skrunk)
                placeBoard.ranPiece(x);
            Shooty shortguesser = new Shooty(placeBoard, guessBoard, 20); //WHY WONT U COOPERATE >:(

            trythis = inputSource.nextLine();
            System.out.print("Enter a guess:");
            trythis = inputSource.nextLine();

            while (!shortguesser.guessThat(trythis))
            {
                System.out.print("Enter a guess:");
                trythis = inputSource.nextLine();
            }

        }

        inputSource.close(); // at the very end
    }
}
