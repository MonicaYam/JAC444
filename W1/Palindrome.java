package workshop1;
/**
 * Workshop1 for JAC444
 * @author Monica Yam
 * @version 1.0
 * @parm args  it is string
 *
 */
public class Palindrome {
	public static void main(String[] args) {
		if(isPalindrome(args[0])) {
	        System.out.println("Command-line argument string: " + args[0] + " is a palindrome!");
		}else {
	        System.out.println("Command-line argument string: " + args[0] + " is not a palindrome.");

		}
	}

	private static boolean isPalindrome(String text) {
		boolean result = true;
		int charSize = text.length();
		Stack mystack = new Stack(charSize);

		for(int i = 0; i < charSize; ++i) {
			mystack.pushArray(text.charAt(i));
		}

		for(int i = 0; i < charSize && result; ++i) {
			result =  text.charAt(i) == mystack.popArray()? true: false;
		}

		return result;
	}
}


