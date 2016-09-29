import java.util.Scanner;

public class H14_27 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		char cont = 'y';
		String email;
		String[] spamwords = {"hello", "how", "are", "john"};
		double score = 0.0;

	//	get input
		System.out.print("Please enter the email to be scored: ");
		email = input.nextLine();

	//	score the spam
		score = score_spam(spamwords, email);

	//	tell the user about it
		output_result(score);
	}

	public static void output_result(double score) {
		System.out.printf("This email was scored %f%% spam!\n", score * 100);
	}

	public static double score_spam(String[] spam_list, String email) {
		int count = 0;
		int last_index;
		String[] words;

		email = email.toLowerCase();
        words = email.split(" ");

		for (String spam: spam_list) {
			last_index = 0;
			while(last_index >= 0) {
				last_index = email.indexOf(spam, last_index);
				if (last_index >= 0) {
					count++;
					last_index++;
				}
			}
		}

		return (((double)count) / ((double)words.length));
	}
}
