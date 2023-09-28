public class Tester
{
    public static void main(String[] args)
    {
        int numRows = 10;
        int numCols = 10;
        Board gameUI = new Board(numCols, numRows);

        gameUI.print();
    }
}