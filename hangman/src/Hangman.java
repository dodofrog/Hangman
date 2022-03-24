// Hangman.java - the class for the hangman game
// Akshit Garg
// March 2022
import java.util.Scanner;

public class Hangman
{
    private String word;
    private String[] fruits = {"apple", "banana", "pepper", "tomato", "Lychee", "Dragonfruit", "Pear", "Orange", "Lemon", "Lime", "Avacado", "Pumpkin", "Watermelon", "Cucumber", "Peaches", "Apricots", "Strawberry", "Lingonberry", "Blackberry", "Blueberry", "Raspberries", "Grapes", "Cranberries"};
    private String[] countries = {"United States", "Canada", "Mexico", "Brazil", "Colombia", "Argentina", "Ukraine", "Russia", "United Kingdom", "France", "Spain", "Switzerland", "Germany", "Italy", "Greece", "Poland", "Sweden", "Ireland", "India", "China", "Taiwan", "Japan", "Rwanda", "Pakistan"};
    private String[] sports = {"Tennis", "Soccer", "Football", "Badminton", "Rugby", "volleyball", "Tchoukball", "Wrestling", "Chess", "Cricket", "Basketball", "Baseball", "Ultimate Frisbee"};
    private int life = 6;

    // Constructor
    public Hangman(int num)
    {
        findWord(num);
    }

    // Constructor 2
    public Hangman(String userWord)
    {
        findWord(userWord);
    }
    
    // Determines what the word will be based on premade lists
    private void findWord(int answer)
    {
        if(answer == 0)
        {
            int rand = (int) Math.random() * fruits.length;
            word = fruits[rand];
        }
        else if(answer == 1)
        {
            int rand = (int) Math.random() * countries.length;
            word = countries[rand];
        }
        else if(answer == 2)
        {
            int rand = (int) Math.random() * sports.length;
            word = sports[rand];
        }
    }

    // Determines what the word will be based on user input
    private void findWord(String userWord)
    {
        word = userWord;
    }

    // Takes a life away
    public void takeLife()
    {
        life--;
    }

    // the toString method - Prints the man based on the lives left
    public String toString()
    {
        String result = "";
        if (life == 6)
            result = "   +----+ \n   |    | \n        | \n        | \n        | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 5)
            result = "   +----+ \n   |    | \n   0    | \n   |    | \n   |    | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 4)
            result = "   +----+ \n   |    | \n   0    | \n  /|    | \n   |    | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 3)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 1)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  /     | \n        | \n     *****\n    ******\n";
        else if(life == 0)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  / \\   | \n        | \n     *****\n    ******\n";
        return result;
    }

    // plays the game
    public void playGame()
    {
        Scanner scan = new Scanner(System.in);
        Scanner numScan = new Scanner(System.in);
        while (true)
        {
            System.out.println("Would you like to choose your own word? (y/n): ");
            String userChoice = scan.nextLine();
            userChoice.toLowerCase();
            if (userChoice.equals("y"))
            {
                System.out.println("What is your word? ");
                String userWord = scan.nextLine();
                findWord(userWord);
                break;
            }
            else if(userChoice.equals("n"))
            {
                while(true)
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
                            findWord(rand);
                        }
                        else
                        {
                            findWord(userNum);
                        }
                        break;
                    }
                    break;
                }
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }
        
    }
}