package app;

public class BadUserInputException extends Exception {
	private static final long serialVersionUID = -5155556679380598302L;

	public BadUserInputException() {
		System.out.println("Bad input, try again!");
	}
}
