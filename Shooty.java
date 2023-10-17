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
            int row = (int) locs.toUpperCase().charAt(0) - 65;
            int col = Integer.parseInt(locs.substring(index)) - 1;
            if (answers.grid[row][col] != 'O')
            {   
                if (!sunkShip(row,col))
                {
                    guesses.grid[row][col] = '!';
                    System.out.println("Hit!");
                }
                else
                {
                    System.out.println("Sunk!");
                }
                
            } //need to implement checker for sunk
            else
            {
                guesses.grid[row][col] = '.';
                System.out.println("Miss!");
            }

            guesses.printBoard();
            tryNum++;
            return false;
        }
    }

    public boolean sunkShip (int rrrow, int cccol)
    {
        int disOrient = orienter(rrrow, cccol);
        int upLe, doRi, cursor;

        if (disOrient == 0)
        {
            cursor = rrrow;
            while (cursor >= 0 && answers.grid[cursor][cccol] != 'O')
            {
                cursor--; 
            }

            upLe = cursor+1; //adjust for the fact
            int temp = answers.grid[0].length;

            while (cursor < temp && answers.grid[cursor][cccol] != 'O')
            {
                cursor++; 
            }
            doRi = cursor;
            
            for (int i = upLe; i < doRi; i++)
            {
                if (guesses.grid[i][cccol] != '!')
                    return false;
            }

            for (int i = upLe; i < doRi; i++)
            {
                guesses.grid[i][cccol] = 'X';
            }
            return true;
        }
        else
        {
            cursor = cccol;
            while (cursor >= 0 && answers.grid[rrrow][cursor] != 'O')
            {
                cursor--; 
            }

            upLe = cursor+1; //adjust for the fact
            int temp = answers.grid[0].length;

            while (cursor < temp && answers.grid[rrrow][cursor] != 'O')
            {
                cursor++; 
            }
            doRi = cursor;
            
            for (int i = upLe; i < doRi; i++)
            {
                if (guesses.grid[rrrow][i] != '!')
                    return false;
            }

            for (int i = upLe; i < doRi; i++)
            {
                guesses.grid[rrrow][i] = 'X';
            }
            return true;
        }
        
    }

    public int orienter (int rrrrow, int ccccol)
    {
        do 
        {
            if(answers.grid[rrrrow][ccccol] == '<')
                return 0; 
            else if (answers.grid[rrrrow][ccccol] == 'O')
                return 1;
            rrrrow--;
        }
        while (rrrrow >= 0);
        return 0;
    }
}
