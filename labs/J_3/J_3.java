import java.util.Scanner;
import java.util.Arrays;

public class J_3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] to_be_sorted;
		int[] sorted;
		int count = 0;
		char hold;

		String inputs;
		String[] process;

		System.out.printf("Please enter an arbitrary amount of integers, separeated by spaces, when you are done please press the enter key: ");
		inputs = input.nextLine();

		process = inputs.split(" ");

		for (int i=0;i<process.length;i++) {
			inputs = process[i];
			if (isNumeric(inputs)) {
				count++;
			}
		}	

		to_be_sorted = new int[count];
		count = 0;

		for (int i=0;i<process.length;i++) {
			if (isNumeric(process[i])) {
				to_be_sorted[count] = Integer.parseInt(process[i]);
				count++;
			}
		}

		sorted = sort_array(to_be_sorted);
		for (int i=0;i<sorted.length;i++) {
			System.out.printf("%d ", sorted[i]);
		}
		System.out.println("");
	}

	public static int[] sort_array(int[] sort_me) {
		int pivot;
		int length = sort_me.length;
		int i = 0;
		int j = length - 1;
		int temp;
		int[] left = new int[0];
		int[] right = new int[0];

		if (length > 1) {
			pivot = sort_me[length/2];

		//  keep going until both sides have met
			while (i <= j) {
			//  find the next item on the left that is larger than the pivot
				while (sort_me[i] < pivot) {
					i++;
				}
			//  find the next item on the right that is smaller than the pivot
				while (sort_me[j] > pivot) {
					j--;
				}
				if (i <= j) {
				//  swap the numbers we found!
					temp = sort_me[i];
					sort_me[i] = sort_me[j];
					sort_me[j] = temp;
					i++;
					j--;
				}
			}

			if (0 < j) {
				left = sort_array(Arrays.copyOfRange(sort_me, 0, j+1));
				for (int k=0;k<j+1;k++) {
					sort_me[k] = left[k];
				}
			}	
			if (i < length) {
				right = sort_array(Arrays.copyOfRange(sort_me, i, length));
				for (int k=i;k<length;k++) {
					sort_me[k] = right[k-i];
				}
			}

		}
		return sort_me;
	}		
	public static boolean isNumeric(String str)
	{
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c) && c != '-') return false;
		}
		return true;
	}
}


