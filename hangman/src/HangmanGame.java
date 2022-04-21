// HangmanGame.java - plays the Hangman class
// A.Garg
// March 2022
import java.util.Scanner;
import java.util.ArrayList;

public class HangmanGame
{
    // Data Fields
    private Hangman player;

    // Constructor
    public HangmanGame()
    {
        resetWord();
    }

    /**
     * ----------------------------METHODS-------------------------------
     */
    
    // Resets the word
    public void resetWord()
    {
        Scanner scan = new Scanner(System.in);
        Scanner numScan = new Scanner(System.in);
        boolean firstScan = false, secondScan = false;
        while (firstScan == false)
        {
            System.out.println("Would you like to choose your own word? (y/n): ");
            String userChoice = scan.nextLine();
            userChoice.toLowerCase();
            if (userChoice.equals("y"))
            {
                System.out.println("What is your word? ");
                String userWord = scan.nextLine();
                player = new Hangman(userWord);
                firstScan = true;
            }
            else if(userChoice.equals("n"))
            {
                while(secondScan == false)
                {
                    System.out.println("Would you like a word about fruits(1), countries(2), sports(3), or randomly chosen(4)? ");
                    int userNum = numScan.nextInt();
                    userNum--;
                    if (userNum < 0 || userNum > 3)
                    {
                        System.out.println("Invalid Input");
                    }
                    else
                    {
                        if(userNum == 3)
                        {
                            int rand = (int)Math.random() * 3;
                            player = new Hangman(rand);
                        }
                        else
                        {
                            player = new Hangman(userNum);
                        }
                        secondScan = true;
                    }
                }
                firstScan = true;
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }
    }

    // plays the game
    public boolean playGame()
    {      
        Scanner scan = new Scanner(System.in);
        boolean gameDone = false, didWin = false;
        int g = 0;
        ArrayList<Character> uniqueChar = new ArrayList<Character>();
        ArrayList<Character> guessedChar = new ArrayList<Character>();

        System.out.println("   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  / \\   | \n        | \n    ******\n   ********");
        for(int i = player.getWord().length(); i > 0; i--)
        {
            if(player.getWord().charAt(i - 1) == ' ')    
                System.out.print("   ");
            else
            {
                System.out.print("_ ");
                uniqueChar.add(player.getWord().charAt(i - 1));
            }  
        }
        int size = uniqueChar.size();

        while(gameDone == false)
        {
            System.out.println("\n\nGuess a word or a letter: ");
            String guess = scan.nextLine();
            if (guess.indexOf(guess.charAt(1)) == -1)
            {
                char charGuess = guess.charAt(0);
                if(player.guessLetter(guess))
                {
                    System.out.println("" + guess + " is in the word");
                    guessedChar.add(charGuess);
                }
                else
                    System.out.println("" + guess + " is not in the word");
            }
            else
            {
                if(player.guessWord(guess))
                {
                    System.out.println("" + guess + " is the word, you won");
                }
                else
                    System.out.println("" + guess + " is not the word");
                didWin = true;
                gameDone = true;
            }

            System.out.println("   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  / \\   | \n        | \n    ******\n   ********");
            for(int i = player.getWord().length(); i > 0; i--)
            {
                if(player.getWord().charAt(i - 1) == ' ')    
                    System.out.print("   ");
                else if(guessedChar.contains(player.getWord().charAt(i - 1)))
                    System.out.print(player.getWord().charAt(i - 1));
                else
                {
                    System.out.print("_ ");
                    uniqueChar.add(player.getWord().charAt(i - 1));
                }  
            }

            for(int i = uniqueChar.size() - 1; i >= 0; i--)
            {
                if(guessedChar.contains(uniqueChar.get(i)))
                    g++;
            }

            if(g == uniqueChar.size())
            {
                didWin = true;
                gameDone = true;
            }
        }
        return didWin;
    }
}