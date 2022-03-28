// HangmanGame.java - plays the Hangman class
// A.Garg
// March 2022
import java.util.Scanner;

public class HangmanGame
{
    // Data Fields
    private Hangman player;

    // Constructor
    public HangmanGame()
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
                    System.out.println("Would you like a word about fruits(1), countries(2), sports(3), or random chosen(4)? ");
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
}