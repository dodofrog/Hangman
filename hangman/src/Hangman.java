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
		System.out.println("Give me a word: ");
		String userWord = scan.nextLine();
		System.out.println("\n\n");
		System.out.println("           +-----------------<====        \n"
				+		   "           |                  |  |        \n"
				+		   "        0000000               |  |        \n"
				+ 		   "      00       00             |  |        \n"
				+ 		   "     0           0            |  |        \n"
				+ 		   "     0           0            |  |        \n"
				+ 		   "     0           0            |  |        \n"
				+ 		   "      00       00             |  |        \n"
				+ 		   "        0000000               |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "          /|\\                 |  |        \n"
				+ 		   "         / | \\                |  |        \n"
				+ 		   "        /  |  \\               |  |        \n"
				+ 		   "       /   |   \\              |  |        \n"
				+ 		   "      /    |    \\             |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "           |                  |  |        \n"
				+ 		   "          / \\                 |  |        \n"
				+ 		   "         /   \\                |  |        \n"
				+ 		   "        /     \\              /    \\      \n"
				+ 		   "       /       \\            /      \\     \n"
				+ 		   "      /         \\    ******************   \n"
				+ 		   "                    ********************   \n"
				+ 		   "                   **********************  \n"
				+ 		   "                  ************************\n");
		
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
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}