import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class J_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Enter an odd number: ");
			int odd = Integer.parseInt(br.readLine());
			if (odd % 2 == 0) {
				throw new LabException("Number is not odd!");
			}

			System.out.print("Enter a prime number that is smaller than 100: ");
			int prime = Integer.parseInt(br.readLine());
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
			int even = Integer.parseInt(br.readLine());

			if (even % 2 != 0) {
				throw new LabException("Number is not a multiple of two!");
			}

			System.out.print("Enter a negative number: ");
			int negative = Integer.parseInt(br.readLine());

			if (negative > 0) {
				throw new LabException("Number is not a negative number!");
			}

			System.out.print("Enter a Capital letter between N and V: ");
			String capital = br.readLine();
			int ascii = capital.charAt(0);
			if (ascii < 78 || ascii > 86) {
				throw new LabException(String.format("%s is not a capital between N and V!", capital.charAt(0), ascii));
			}
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

		
