import java.util.Scanner;

/**
 * Write a method called euclideanDistance which takes in two arrays 
 * of type double of equal length representing points in a Euclidean 
 * space and calculates the Euclidean distance between them.  
 * The arrays can be any length in size but your function may assume 
 * that the arrays will always be the same size.  The arrays can be of any length.
 */
public class J_12 {

	public static void main(String[] args) {
		double[] first = {0.0, 0.0, 0.0};
		double[] second = {1.0, 1.0, 1.0};

		System.out.printf("Distance is: %f\n", euclideanDistance(first, second));

	}

	/**
	 * calculates the euclideanDistance between any two vectors
	 * @param arr_one first vector
	 * @param arr_two second vector
	 * @return euclideanDistance between the inputs
	 */
	public static double euclideanDistance(double[] arr_one, double[] arr_two) {
		double sum = 0.0;
		for (int i=0;i<arr_one.length;i++) {
			sum += Math.pow((arr_one[i] - arr_two[i]), 2);
		}

		return Math.sqrt(sum);
	}
}
