import java.util.Scanner;

public class J_1 {
	public static void main(String[] args) {
		Scanner br = new Scanner(System.in);

		try {
			System.out.print("Enter an odd number: ");
			int odd = br.nextInt();
			if (odd % 2 == 0) {
				throw new LabException("Number is not odd!");
			}

			System.out.print("Enter a prime number that is smaller than 100: ");
			int prime = br.nextInt();
			if (prime < 100 || prime > 1) {
				boolean[] sieve = primeSieve();
				if (!sieve[prime]) {
					throw new LabException("Number is not prime!");
				}
			}
			else {
				throw new LabException("Number is not within bounds");
			}

			System.out.print("Enter a multiple of two: ");
			int even = br.nextInt();

			if (even % 2 != 0) {
				throw new LabException("Number is not a multiple of two!");
			}

			System.out.print("Enter a negative number: ");
			int negative = br.nextInt();

			if (negative > 0) {
				throw new LabException("Number is not a negative number!");
			}

			br.nextLine();
			System.out.print("Enter a Capital letter between N and V: ");
			char capital = br.nextLine().charAt(0);
			int ascii = capital;
			if (ascii < 78 || ascii > 86) {
				throw new LabException(String.format("%s is not a capital between N and V!", capital, ascii));
			}

			System.out.print("Enter a number that satisfies the equation x^2+5x+6=0: ");
			int quad = br.nextInt();

			if ((quad*quad + 5 * quad + 6) != 0) {
				throw new LabException(String.format("%d^2 + 5 * %d + 6 != 0 !!", quad, quad));
			}
			System.out.println("Congratulations! You've passed the test");
		} catch (NumberFormatException ex) {
			System.out.println("You must enter an Integer Number");
			return;
		} catch (LabException ex) {
			System.out.println(ex.getMessage());
			return;
		}


	}

	//	the sieve!
	public static boolean[] primeSieve() {
		boolean[] primes = new boolean[101];
	//	set up the sieve
		for (int i=1;i<101;i++) {
			primes[i] = true;
		}
		for (int i=2;i<101;i+=2) {
			primes[i] = false;
		}
		primes[0] = false;
		for (int i=3;i<100;i+=2) {
			if (primes[i]) {
				for (int j=2;(i*j)<100;j++) {
					primes[i*j] = false;
				}
			}
		}
		return primes;
	}		

}

		
