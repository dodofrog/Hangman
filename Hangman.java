// Hangman.java - the class for the hangman game
// Akshit Garg
// March 2022
import java.util.ArrayList;

public class Hangman
{
    private String word;
    private String[] fruits = {"apple", "banana", "pepper", "tomato", "lychee", "dragonfruit", "pear", "orange", "lemon", "lime", "avocado", "pumpkin", "watermelon", "cucumber", "peaches", "apricots", "strawberry", "lingonberry", "blackberry", "blueberry", "raspberries", "grapes", "cranberries"};
    private String[] countries = {"United States", "Canada", "Mexico", "Brazil", "Colombia", "Argentina", "Ukraine", "Russia", "United Kingdom", "France", "Spain", "Switzerland", "Germany", "Italy", "Greece", "Poland", "Sweden", "Ireland", "India", "China", "Taiwan", "Japan", "Rwanda", "Pakistan"};
    private String[] sports = {"Tennis", "Soccer", "Football", "Badminton", "Rugby", "volleyball", "Tchoukball", "Wrestling", "Chess", "Cricket", "Basketball", "Baseball", "Ultimate Frisbee"};
    private int life = 6;

    // Constructors
    public Hangman(int answer)
    {
        findWord(answer);
    }

    // Another constructor
    public Hangman(String userWord)
    {
        findWord(userWord);
    }
    
    /**
     * ---------------------------------------METHODS---------------------------------------------
     */

    // Determines what the word will be based on premade lists
    private void findWord(int answer)
    {
        if(answer == 0)
        {
            int rand = (int) (Math.random() * fruits.length);
            word = fruits[rand];
        }
        else if(answer == 1)
        {
            int rand = (int) (Math.random() * countries.length);
            word = countries[rand];
        }
        else if(answer == 2)
        {
            int rand = (int) (Math.random() * sports.length);
            word = sports[rand];
        }
    }

    // Determines what the word will be based on user input
    private void findWord(String userWord)
    {
        userWord.toLowerCase();
        word = userWord;
    }

    // Takes a life away
    public void takeLife()
    {
        life--;
    }

    // Returns the lives of the player
    public int getLife()
    {
        return life;
    }

    // Sees if the full word has been guessed
    public boolean hasGuessedWord(ArrayList<Character> guess)
    {
        boolean didGuess = false;
        for(int i = 0; i < word.length(); i++)
        {
            if(guess.contains(word.charAt(i)))
                didGuess = true;
            else
            {
                didGuess = false;
                i = word.length();
            }
        }
        return didGuess;
    }

    // Guess a word
    public boolean guessWord(String wordGuess)
    {
        boolean didGuess = false;
        wordGuess.toLowerCase();
        if (wordGuess.equals(word.toLowerCase()))
            didGuess = true;
        else
            return didGuess;
        return didGuess;
    }

    // Guess a letter
    public boolean guessLetter(String letter)
    {
        boolean didGuess = false;
        letter.toLowerCase();
        if (word.indexOf(letter) != -1)
            didGuess = true;
        else
            return didGuess;
        return didGuess;
    }

    // Returns the word
    public String getWord()
    {
        return word;
    }

    // the toString method - Prints the man based on the lives left
    public String toString()
    {
        String result = "";
        if (life == 6)
            result = "   +----+ \n   |    | \n        | \n        | \n        | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 5)
            result = "   +----+ \n   |    | \n   0    | \n        | \n        | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 4)
            result = "   +----+ \n   |    | \n   0    | \n   |    | \n   |    | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 3)
            result = "   +----+ \n   |    | \n   0    | \n  /|    | \n        | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 2)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n        | \n        | \n        | \n     *****\n    ******\n";
        else if(life == 1)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  /     | \n        | \n     *****\n    ******\n";
        else if(life == 0)
            result = "   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  / \\   | \n        | \n     *****\n    ******\n";
        return result;
    }
}