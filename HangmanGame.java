// HangmanGame.java - plays the Hangman class
// A.Garg
// March 2022
import java.util.Scanner;
import java.util.ArrayList;

public class HangmanGame
{
    // Data Fields
    private Hangman player;

    // No Constructor

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
        resetWord();  
        Scanner scan = new Scanner(System.in);
        boolean gameDone = false, didWin = false;
        ArrayList<Character> guessedChar = new ArrayList<Character>();

        System.out.println(player);
        for(int i = 0; i < player.getWord().length(); i++)
        {
            if(player.getWord().charAt(i) == ' ')    
                System.out.print("   ");
            else
            {
                System.out.print("_ ");
            }  
        }

        while(gameDone == false)
        {
            System.out.println("\n\nGuess a word or a letter: ");
            String guess = scan.nextLine();
            if (guess.length() == 1)
            {
                char charGuess = guess.charAt(0);
                if(player.guessLetter(guess))
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is in the word");
                    guessedChar.add(Character.toLowerCase(charGuess));
                }
                else
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is not in the word");
                    player.takeLife();
                }    
            }
            else
            {
                if(player.guessWord(guess))
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is the word, you won");
                    for(int i = 0; i < player.getWord().length(); i ++)
                    guessedChar.add(Character.toLowerCase(player.getWord().charAt(i)));
                    didWin = true;
                    gameDone = true;
                }
                else
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is not the word");
                    player.takeLife();
                }
            }

            System.out.println(player);
            for(int i = 0; i < player.getWord().length(); i++)
            {
                if(player.getWord().charAt(i) == ' ')    
                    System.out.print("   ");
                else if(guessedChar.contains(Character.toLowerCase(player.getWord().charAt(i))))
                    System.out.print(player.getWord().charAt(i) + " ");
                else
                {
                    System.out.print("_ ");
                }  
            }

            if(player.hasGuessedWord(guessedChar))
            {
                System.out.println("\nYOU WON!!\n\nLives Left: " + player.getLife());
                didWin = true;
                gameDone = true;
            }

            if(player.getLife() == 0)
            {
                System.out.println("\nYOU LOST\nThe Word Was: " + player.getWord());
                didWin = false;
                gameDone = true;
            }
        }
        return didWin;
    }
}