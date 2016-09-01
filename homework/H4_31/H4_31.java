import java.util.Scanner;


public class H4_31 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String binary;
		int deci = 0;
		int binarylength = 0;
		double placemulti;

		System.out.print("Enter a number in binary: ");
		binary = input.nextLine();

		binarylength = binary.length();

		for (int i=0;i<binarylength;i++) {
			placemulti = Math.pow(2, i);
			deci = Double.valueOf(placemulti).intValue() * Character.getNumericValue(binary.charAt(binarylength - i - 1)) + deci;
			System.out.println(placemulti);
		}

		System.out.printf("Your binary number, %s, is %d in decimal!\n", binary, deci);
	}
}
