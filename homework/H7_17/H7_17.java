import java.util.Random;
import java.util.Arrays;

public class H7_17 {
	public static void main(String[] args) {
		Random rnd = new Random();

		int[] record = new int[13];
		Arrays.fill(record, 0);

		int temp;

		for (int i=0;i<36000000;i++) {
			temp = rnd.nextInt(6) + 1;
			temp += rnd.nextInt(6) + 1;
			record[temp]++;
			if (i % 3600000 == 0) {
				System.out.printf("Computed %d\n", i);
			}
		}

		for (int i=2;i<=12;i++) {
			System.out.printf("%d\t", i);
		}
		System.out.println();
		for (int i=2;i<=12;i++) {
			System.out.printf("%d\t", record[i]);
		}
		System.out.println();
	}
}
