import java.util.Scanner;

public class H5_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		for (int i=1;i<11;i++) {
			for(int j=0;j<i;j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
