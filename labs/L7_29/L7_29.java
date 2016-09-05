import java.util.Scanner;

public class L7_29 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] fibs = new int[100];
		int fib = 0;
		char cont = 'y';

		fibs = fib_loop(100);

		while (cont == 'y') {
			System.out.print("Please entere the fib number you want: ");
			fib = input.nextInt();
				
			System.out.printf("The %dth fib number is %d\n", fib, fibs[fib-1]);

			System.out.print("Do you want to continue? (y/n): ");
			cont = input.next().charAt(0);
		}

		for (int i=0;i<100;i++) {
			if (fibs[i] > fibs[i+1]) {
				System.out.printf("The largest Fib number that this system can display is %d\n", fibs[i]);
				break;
			}
		}
	}


	public static int[] fib_loop(int n) {
		int[] fibs = new int[100];
		fibs[0] = 0;
		fibs[1] = 1;
		int current = 1;
		try {
			for (int i=2;i<n;i++) {
				fibs[i] = fibs[i-1] + fibs[i-2];
			}
		}
		catch (Exception ex) {
			System.out.println("Something went wrong here!");
		}
		return fibs;
	}
}
