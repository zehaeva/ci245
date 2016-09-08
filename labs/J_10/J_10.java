import java.util.Scanner;

public class J_10 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Print(arr);
	}

	public static void Print(int[] array) {
		System.out.printf("%s\n", Join(array, ","));
	}
	
	public static String Join(int[] array, String str) {
		String hold = "";
		for (int val: array) { 
			if (hold.length() > 0) {
				hold += str + " " + val;
			}
			else {
				hold = "" + val;
			}
		}

		return hold;
	}
}

			
