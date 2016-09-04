import java.util.Scanner;
import java.util.Arrays;

public class L7_27 {
	public static void main(String[] args) {
		boolean[] primes = new boolean[1001];
		primes = primeSieve(1000);
		for (int i=2;i<1001;i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}
	//	the sieve!
	public static boolean[] primeSieve(int max) {
		boolean[] primes = new boolean[(max + 1)];
		Arrays.fill(primes, true);
	//	set up the sieve
		for (int i=2;i<=max;i+=2) {
			primes[i] = false;
		}
		primes[0] = false;
		for (int i=3;i<max;i+=2) {
			if (primes[i]) {
				for (int j=2;(i*j)<max;j++) {
					primes[i*j] = false;
				}
			}
		}
		return primes;
	}
}

