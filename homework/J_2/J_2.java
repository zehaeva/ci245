import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
	
public class J_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
		try {
			System.out.print("Enter an Integer: ");
			int shift_me = Integer.parseInt(br.readLine());
			System.out.printf("%d * 2 == %d\n", shift_me, (shift_me << 1));
			System.out.printf("%d / 2 == %d\n", shift_me, (shift_me >> 1));
		} catch ( NumberFormatException ex) {
			System.out.println("You must enter an Integer Number");
			return;
		}
	}
}

