public class Shooty {
    Board answers;
    Board guesses;
    int tryNum = 1; //human counting
    int maxTries = 0;
    Ship justforcheck = new Ship (0,null);

    public Shooty (Board play1, Board play2, int tries)
    {
        answers = play1;
        guesses = play2;
        maxTries = tries;
    }

    public boolean guessThat (String locs) //return true when guesses over;
    {
        if (tryNum > maxTries)
            return true; 
        if (tryNum == maxTries)
            System.out.println("Final guess!");

        if (justforcheck.inCoords(locs) < 0 )
        {
            System.out.println("Invalid guess");
            return false;
        }
        else
        {
            int index = justforcheck.inCoords(locs);
            int row = (int) locs.charAt(0) - 65;
            int col = Integer.parseInt(locs.substring(index));
            if (answers.grid[row][col] != '~')
            {
                guesses.grid[row][col] = '!';
            } //need to implement checker for sunk
            else
            {
                guesses.grid[row][col] = '.';
            }

            tryNum++;
            return false;
        }
    }


}
