// HangmanGame.java - plays the Hangman class
// A.Garg
// March 2022
import java.util.Scanner;
import java.util.ArrayList;

public class HangmanGame
{
    // Data Fields
    private Hangman player;
    private Scanner scan;

    //Constructor
    public HangmanGame()
    {
        scan = new Scanner(System.in);
        resetWord();
    }

    /**
     * ----------------------------METHODS-------------------------------
     */
    
    // Resets the word
    public void resetWord()
    {
        boolean firstScan = false, secondScan = false;
        while (firstScan == false)
        {
            System.out.println("Would you like to choose your own word? (y/n): ");
            String userChoice = scan.nextLine().toLowerCase();
            if (userChoice.equals("y"))
            {
                System.out.println("What is your word? ");
                player = new Hangman(scan.nextLine());
                firstScan = true;
            }
            else if(userChoice.equals("n"))
            {
                while(secondScan == false)
                {
                    System.out.println("Would you like a word about fruits(1), countries(2), sports(3), or randomly chosen(4)? ");
                    int userNum = scan.nextInt() - 1;
                    if (userNum < 0 || userNum > 3)
                        System.out.println("Invalid Input");
                    else
                    {
                        if(userNum == 3)
                            player = new Hangman((int) (Math.random() * 3));
                        else
                            player = new Hangman(userNum);
                        secondScan = true;
                    }
                }
                firstScan = true;
            }
            else
                System.out.println("Invalid Input");
        }
    }

    // plays the game
    public boolean playGame()
    {     
        boolean gameDone = false, didWin = false;
        String playerWord = player.getWord();
        ArrayList<Character> guessedChar = new ArrayList<Character>(), incorrectGuesses = new ArrayList<Character>();

        System.out.println(player);
        for(int i = 0; i < playerWord.length(); i++)
        {
            if(playerWord.charAt(i) == ' ')    
                System.out.print("   ");
            else
                System.out.print("_ ");
        }

        while(gameDone == false)
        {
            System.out.println("\n\nGuess a word or a letter: ");
            String guess = scan.nextLine();
            if (guess.length() == 1)
            {
                char charGuess = Character.toLowerCase(guess.charAt(0));

                if(player.guessLetter(guess))
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is in the word");
                    guessedChar.add(Character.toLowerCase(charGuess));
                }
                else
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is not in the word");
                    if(!(incorrectGuesses.contains(charGuess)))
                        incorrectGuesses.add(charGuess);                  
                    player.takeLife();
                }    
            }
            else
            {
                if(player.guessWord(guess))
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is the word");
                    for(int i = 0; i < playerWord.length(); i ++)
                        guessedChar.add(Character.toLowerCase(playerWord.charAt(i)));
                    didWin = true;
                    gameDone = true;
                }
                else
                {
                    System.out.println("\n--===============================--\n" + "'" + guess + "'" + " is not the word");
                    player.takeLife();
                }
            }

            System.out.println("\nIncorrect Guesses: ");
            for(int i = 0; i < incorrectGuesses.size(); i++)
            {
                if(i != incorrectGuesses.size() - 1)
                    System.out.print(incorrectGuesses.get(i) + ", ");
                else
                    System.out.println(incorrectGuesses.get(i));
            }  
            System.out.println();

            System.out.println(player);
            for(int i = 0; i < playerWord.length(); i++)
            {
                if(playerWord.charAt(i) == ' ')    
                    System.out.print("   ");
                else if(guessedChar.contains(Character.toLowerCase(playerWord.charAt(i))))
                    System.out.print(playerWord.charAt(i) + " ");
                else
                    System.out.print("_ ");
            }

            if(player.hasGuessedWord(guessedChar))
            {
                gameDone = true;
                didWin = true;
            }

            if(player.getLife() == 0)
            {
                gameDone = true;
                didWin = false;
            }

            if(gameDone == true)
            {
                if(didWin == true)
                    System.out.println("\nYOU WON!!\n\nLives Left: " + player.getLife());
                else   
                    System.out.println("\nYOU LOST\nThe Word Was: " + player.getWord());
            }
        }
        return didWin;
    }

    public void endGame() {
        System.out.println("Thanks for playing!");
        scan.close();
    }
}