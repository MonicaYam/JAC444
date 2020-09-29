package workshop1;

/**
 * This class is my version of Stack class
 * @author Monica Yam
 * @version 1.0
 *
 */
public class Stack {
	private int currPos = 0;
	private char[] charArray;

	/**
	 * Constructor
	 * @param size  it for charArray
	 */
	public Stack(int size) {
		charArray = new char[size];
	}

	/**
	 * push character to char array
	 * increase currPos
	 * @param character
	 */
	public void pushArray(char character) {
		charArray[currPos++] = character;
	}

	/**
	 * return char from char array to main
	 * @return char from charArray
	 */
	public char popArray() {
		return charArray[--currPos];
	}
}
