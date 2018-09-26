package eecs2030.lab7;

import java.util.List;
import java.util.ArrayList;

/**
 * A utility class containing several recursive methods (Lab 7, W2018)
 * 
 * <pre>
 * 
 * For all methods in this API, you are forbidden to use any loops, nor 
 * String or List based methods such as "contains", or methods that use regular expressions
 * </pre>
 * 
 * @author
 *
 */
public final class RecursiveMethods {

	private RecursiveMethods() {
	}

	/**
	 * Given a string, recursively compress all sets of repeating adjacent chars
	 * within an existing string to a single char. For example, "xyyzzz" yields
	 * "xyz".
	 * 
	 * <pre>
	 * 
	 * removeRepeats("fffaaar Ouuut") returns "far Out"
	 * removeRepeats("nooooo  wooorrriiies") returns "no wories"
	 * removeRepeats("Tomorrow") returns "Tomorow"
	 * 
	 * </pre>
	 * 
	 * @param str
	 *            a string of characters
	 * @return a version of the original string with all repeating adjacent
	 *         sequences of the same character, reduced to a single character
	 */
	public static String removeRepeats(String str) {

		int length = str.length() - 1;
		if (str.equals("") || str.length() == 1) {
			return str;
		} else if (str.charAt(length) == str.charAt(length - 1)) {
			return removeRepeats(str.substring(0, length));
		}

		else {
			return removeRepeats(str.substring(0, length)) + str.charAt(length);
		}

	}

	/**
	 * Return the decimal (integer) representation of a given binary number
	 * (represented as a string).
	 * 
	 * 
	 * <p>
	 * E.g. "110" = 1*2^2 + 1*2^1 + 0*2^0 = 4 + 2 + 0 = 6.
	 * </p>
	 * <p>
	 * This method should compute the integer value recursively (no loops
	 * allowed). In this method, the input binary string may have leading zeros
	 * (e.g. "00011" = 3).
	 * </p>
	 * 
	 * <pre>
	 * 
	 * binaryToInt("0") returns 0
	 * binaryToInt("101") returns 5
	 * binaryToInt("11011") returns 27
	 * binaryToInt("111") returns 7
	 * binaryToInt("0111") returns 7
	 * 
	 * </pre>
	 * 
	 * @param b
	 *            a non-empty, binary string
	 * @return an integer that represents the decimal value of b
	 */
	public static int binaryToInt(String b) {
		int x = b.length() - 1;

		if (b.length() == 0) {
			return 0;
		} else if (b.charAt(0) == '1') {
			return (int) (1 * (Math.pow(2.0, x))) + binaryToInt(b.substring(1));
		} else {
			return (int) (0 * (Math.pow(2.0, b.length() - 1))) + (binaryToInt(b.substring(1)));
		}
	}

	/**
	 * Return the binary representation of a given number (see Lab 7 URL)
	 * 
	 * <p>
	 * Note that the binary representation of 0 should be 0, and, apart from
	 * this case, there should be no leading 0's in the binary representation.
	 * I.e. 2 = "10" not "0010"
	 * </p>
	 * 
	 * <pre>
	 * 
	 * intToBinary(7) returns "111"
	 * intToBinary(2) returns "10"
	 * intToBinary(13) returns "1101"
	 * intToBinary(0) returns "0"
	 * 
	 * </pre>
	 * 
	 * @param value
	 *            an integer to be converted to a binary string
	 * @return a string of binary digits representing the integer "value"
	 */
	public static String intToBinary(int value) {
		if (value == 0) {
			return "0";
		} else {
			String s = intToBinary(value / 2);
			int sum = (value % 2 + 10 * Integer.parseInt(s));
			return Integer.toString(sum);
		}

	}

	/**
	 * Returns the index of the element equal to the integer "target" in the
	 * specified sorted list.
	 * 
	 * <p>
	 * Assumptions:<br>
	 * The list t is not modified by this method. If target exists it exists
	 * only once in the list.
	 * </p>
	 * 
	 * <pre>
	 * 
	 * indexOfTarget([1,2,3], 1 ) gives index = 0;
	 * indexOfTarget([1,2,3], 2 ) gives index = 1;
	 * indexOfTarget([1,2,3], 3 ) gives index = 2;
	 * indexOfTarget([1,2,3], 10 ) gives index = -1;
	 * 
	 * </pre>
	 * 
	 * @param t
	 *            a list sorted in ascending order
	 * @param target
	 *            the integer we want to find the index of
	 * @return the index of the element in t that is equal to the target, or -1
	 *         if the target is not present in the list
	 * 
	 */
	public static int findTarget(List<Integer> t, int target) {
		if (t.size() == 0) {
			return -1;
		}
		if (t.get(t.size() - 1) == target) {
			return t.size() - 1;
		} else {
			return findTarget(t.subList(0, t.size() - 1), target);
		}
	}

	/**
	 * Given an array of ints, is it possible to divide the ints into two
	 * groups, so that the sum of one group is a multiple of 12, and the sum of
	 * the other group is odd. Every int must be in one group or the other
	 * (never in both).
	 * 
	 * <p>
	 * Hint: Write a recursive helper method (a method that is called from
	 * twoGroups and will actually do the recursion). This helper method can
	 * take whatever arguments you like, although no loops are allowed!
	 * </p>
	 * 
	 * <pre>
	 * 
	 * twoGroups([6, 6, 5]) returns true 
	 * twoGroups([5, 5, 6]) returns false
	 * twoGroups([5, 5, 6, 1]) returns true
	 * twoGroups([6, 5, 6, 1]) returns false
	 * 
	 * </pre>
	 * 
	 * @param t
	 *            an array of integers
	 * @return a boolean indicating true if there exists a non empty subset of
	 *         integers in nums whose sum is a multiple of 12, where the sum of
	 *         the remaining non empty subset of integers is odd
	 */
	public static boolean twoGroups(List<Integer> t) {
		return trackSums(t, 0, 0, 0);
	}

	private static boolean trackSums(List<Integer> t, int index, int sum1, int sum2) {
		if (t.size() == 0) {
			return false;
		}
		if (index == t.size()) {
			if ((sum1 % 12 == 0) && (sum2 % 2 == 1)) {
				return true;
			} else {
				return false;
			}
		}
		sum1 += t.get(index);
		sum2 += t.get(index);
		boolean sums = trackSums(t, index + 1, sum1, sum2 - t.get(index))
				|| trackSums(t, index + 1, sum1 - t.get(index), sum2);

		return sums;
	}

}
