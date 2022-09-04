
/**
 * Exception thrown when an invalid SSN is entered.
 */
public class SocSecException extends Exception {
	/**
	 * Parameterized constructor for exception.
	 * @param error Short description of error.
	 */
	public SocSecException(String error) {
		super("Invalid social security number, " + error);
	}
}
