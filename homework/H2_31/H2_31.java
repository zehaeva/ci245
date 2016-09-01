import java.util.Scanner;

public class H2_31 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int max_n;

		System.out.print("Enter the max number to compute: ");
		max_n = input.nextInt();


		System.out.printf("number\tsquare\tcube\n");
		for (int i=0;i<=max_n;i++) {
			System.out.printf("%d\t%d\t%d\n", i, i*i, i*i*i);
		}
	}
}
