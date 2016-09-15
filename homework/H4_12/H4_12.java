import java.util.Scanner;
import java.util.Arrays;

/**
 * class counts the number of times each character appears
 */
public class H4_12 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String haystack;
		char needle;
		char cont = 'y';
		int[] count = new int[26];
		Arrays.fill(count, 0);

		while (cont =='y') {
			System.out.print("Enter a line of text to search: ");
			haystack = input.nextLine().toLowerCase();

			for (int i=0;i<26;i++) {
				needle = (char)(i + 97);
				count[i] = countCharacters(haystack, needle);
				if (count[i] > 0) {
					System.out.printf("Found %c %d times!\n", needle, count[i]);
				}
			}

			for (int i=0;i<26;i++) {
				System.out.printf("%c\t", (char)(i+97));
			}
			System.out.println();
			for (int i=0;i<26;i++) {
				System.out.printf("%d\t", count[i]);
			}

			System.out.print("\n\nAgain? (y/n): ");
			cont = input.nextLine().charAt(0);
		}
	}

	public static int countCharacters(String haystack, char needle) {
		int count = 0;
		int last_index = 0;

		while (last_index >= 0) {
			last_index = haystack.indexOf(needle, last_index);
			if (last_index >= 0) {
				count++;
				last_index++;
			}
		}

		return count;
	}
}
