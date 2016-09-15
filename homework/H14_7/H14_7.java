import java.util.Scanner;

/**
 * Class to output senetnces in pig latin
 */
public class H14_7 {
	/** 
	 * main function to get input and output sentences in piglatin
	 * @param args unused
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String value;
		String[] words;
		String output;
		char cont = 'y';

		while (cont == 'y') {
			output = "";
			System.out.print("Enter some text: ");
			value = input.nextLine();

			words = value.split(" ");

			for (String word: words) {
				output = output + printLatinWord(word);
			}

			System.out.printf("%s\n", output);
			System.out.print("Another? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}

	/**
	 * prints a word in pig latin
	 * @param word word to be converted to pig latin
	 * @return word in pig latin
	 */
	public static String printLatinWord(String word) {
		String output = "";
		int word_length = word.length();
		String trailing = " ";

		if (word_length > 1) {
			if (!Character.toString(word.charAt(word_length - 1)).matches("[A-Za-z0-9]")) {
				word_length--;
				trailing = word.charAt(word_length) + trailing;
			}
			output = output + word.substring(1, word_length) + word.charAt(0) + "ay" + trailing;
		} else {
			output = output + word + trailing;
		}

		return output;
	}
}
