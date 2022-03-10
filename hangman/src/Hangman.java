import java.util.Scanner;
public class Hangman
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("HHHHH    HHHHH  AAAAAAAAAA  NNNN     NNNN  GGGGGGGGGGG  MMMM     MMMM  AAAAAAAAAA  NNNN     NNNN\n"
				+ 		   "HHHHH    HHHHH  AAA    AAA  NNNNNN   NNNN  GGGGGGGGGGG  MMMMM   MMMMM  AAA    AAA  NNNNNN   NNNN\n"
				+ 		   "HHHHH    HHHHH  AAA    AAA  NNNNNNNN NNNN  GGG          MMMMMMMMMMMMM  AAA    AAA  NNNNNNNN NNNN\n"
				+ 		   "HHHHHHHHHHHHHH  AAAAAAAAAA  NNNN NNNNNNNN  GGG    GGGG  MMMM MMM MMMM  AAAAAAAAAA  NNNN NNNNNNNN\n"
				+ 		   "HHHHHHHHHHHHHH  AAAAAAAAAA  NNNN   NNNNNN  GGG    GGGG  MMMM     MMMM  AAAAAAAAAA  NNNN   NNNNNN\n"
				+ 		   "HHHHH    HHHHH  AAA    AAA  NNNN    NNNNN  GGG      GG  MMMM     MMMM  AAA    AAA  NNNN    NNNNN\n"
				+ 		   "HHHHH    HHHHH  AAA    AAA  NNNN     NNNN  GGGGGGGGGGG  MMMM     MMMM  AAA    AAA  NNNN     NNNN\n"
				+ 		   "HHHHH    HHHHH  AAA    AAA  NNNN     NNNN  GGGGGGGGGGG  MMMM     MMMM  AAA    AAA  NNNN     NNNN\n");
		System.out.println("\nThe Rules are Simple: \n- Guess the word letter by letter\n- If you get a letter wrong, the man loses a body part\n- You lose when there are no body parts left\n");
		System.out.println("Would you like to choose a word? (y/n)");
		String yorn = scan.nextLine();
		yorn.toUpperCase();
		if(yorn.equals("y"))
		{
			System.out.println("Give me a word: ");
			String userWord = scan.nextLine();
			String[] word = new String[userWord.length()];
			for(int i = 0; i < word.length; i++)
			{
				word[i] = userWord.substring(i,i);
			}
			String[] guess = new String[word.length];
			for(int i = 0; i < guess.length; i++)
			{
				guess[i] = "_ ";
			}
			System.out.print("\nWord: ");
			for(String character: guess)
			{
				System.out.print(character);
			}
			
			System.out.println("\nGuess a letter: ");
			String userLetter = scan.next();
		}
		else if(yorn.equals("n"))
		{
			String[] countries = {"United States", "Canada", "Mexico", "Brazil", "Colombia", "Argentina", "Ukraine", "Russia", "United Kingdom", "France", "Spain", "Switzerland", "Germany", "Italy", "Greece", "Poland", "Sweden", "Ireland", "India", "China", "Taiwan", ""}
		}
		// System.out.println("\n\n");
		// System.out.println("   +----+ \n   |    | \n   0    | \n  /|\\   | \n   |    | \n  / \\   | \n        | \n     *****\n    ******\n");
	}
}