import java.util.Scanner;

public class H4_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String value;
		String[] words;
		String output = "";

		System.out.print("Enter some text: ");
		value = input.nextLine();

		words = value.split(" ");

		for (String word: words) {
			if (word.length() > 1) {
				output = output + word.substring(1, word.length()) + word.charAt(0) + "ay ";
			} else {
				output = output + word + " ";
			}
		}

		System.out.printf("%s\n", output);
	}
}
