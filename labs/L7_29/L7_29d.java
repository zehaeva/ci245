import java.util.Scanner;

public class L7_29d {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 500;

		double[] fibs = new double[count];
		int fib = 0;
		char cont = 'y';

		fibs = fib_loop(count);

		while (cont == 'y') {
			System.out.print("Please entere the fib number you want(calculated with doubes!): ");
			fib = input.nextInt();
				
			System.out.printf("The %dth fib number is %f\n", fib, fibs[fib-1]);

			System.out.print("Do you want to continue? (y/n): ");
			cont = input.next().charAt(0);
		}

		for (int i=0;i<(count-1);i++) {
			if (fibs[i] > fibs[i+1]) {
				System.out.printf("The largest Fib number that this system can display is %f\n", fibs[i]);
				break;
			}
		}
		System.out.printf("The largest Fib number that this system can accurately display is %f\n", fibs[78]);
	}


	public static double[] fib_loop(int n) {
		double[] fibs = new double[500];
		fibs[0] = 0;
		fibs[1] = 1;
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
