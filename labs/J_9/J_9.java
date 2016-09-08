import java.util.Scanner;

/**
 * Class for implementing Left, Right and Mid
 */
public class J_9 {
	public static void main(String[] args) {
		String str = "hello world!";
		System.out.printf("%s\n", left(str, 4));
		System.out.printf("%s\n", right(str, 5));
		System.out.printf("%s\n", mid(str, 4));
		System.out.printf("%s\n", mid(str, 3, 4));
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
		return str.substring((str.length() - length), str.length());
	}
	/**
	 * Returns a string that contains all the characters starting from a specified position in a string.
	 * @return string of specified length 
	 * @param str String to parse
	 * @param start index of the start of the string to return
	 */
	public static String mid(String str, int start) {
		return str.substring(start, str.length());
	}
	/**
	 * Returns a string that contains all the characters starting from a specified position in a string.
	 * @return string of specified length 
	 * @param str String to parse
	 * @param start index of the start of the string to return
	 * @param length number of characters to return
	 */
	public static String mid(String str, int start, int length) {
		if ((start + length) > str.length()) {
			length = str.length() - start;
		}
		return str.substring(start, length + start);
	}
	
}
