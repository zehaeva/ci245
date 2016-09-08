import java.util.Scanner;

/**
 * Class for implementing Left, Right and Mid
 */
public class J_9 {
	public static void main(String[] args) {
	}

	/**
	 * Returns a string containing a specified number of characters from the left side of a string.
	 * @return string of specified length 
	 * @param str String to parse
	 * @param length number of characters to return
	 */
	public static String left(String str, int length) {
		return str.substring(0, length);
	}
	/**
	 * Returns a string containing a specified number of characters from the right side of a string.
	 * @return string of specified length
	 * @param str String to parse
	 * @param length number of characters to return
	 */
	public static String right(String str, int length) {
		return str.substring((str.length() - length), length);
	}
	/**
	 * Returns a string that contains all the characters starting from a specified position in a string.
	 * @return string of specified length 
	 * @param str String to parse
	 * @param start number of characters to return
	 */
	public static String mid(String str, int start) {
		return str.substring(start);
	}
	
}
