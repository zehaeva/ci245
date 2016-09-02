
// class to find all pytagean tripples
public class H5_21 {
	public static void main(String[] args) {
		int max = 500;

		System.out.println("Looking for all Pythagrean Tripples!");
		for (int i=1;i<=max;i++) {
			for (int j=i;j<=max;j++) {
				for (int k=1;k<=max;k++) {
					if (i * i + j * j == k * k) {
						System.out.printf("Tripple found! %d^2 + %d^2 = %d^2\n", i, j, k);
					}
				}
			}
		}
	}
}
