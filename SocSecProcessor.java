import java.util.Scanner;

/**
 * Driver for Lab1B.
 */
public class SocSecProcessor {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		char continueCharacter = 'y';
		
		while (continueCharacter == 'y') {
			try {
				System.out.print("Name? ");
				String name = reader.nextLine();
				
				System.out.print("SSN? ");
				String ssn = reader.nextLine();
				
				if (isValid(ssn)) {
					System.out.print(String.format("%s %s is valid\n", name, ssn));
				}
			} catch (SocSecException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.print("Continue? ");
				continueCharacter = reader.nextLine().toLowerCase().charAt(0);
			}
		}
		
		reader.close();
	}

	/**
	 * Checks validity of ssn
	 * @param ssn Social Security Number to be checked
	 * @return true if valid
	 * @throws SocSecException
	 */
	public static boolean isValid(String ssn) throws SocSecException {
		if (ssn.length() != 11) {
			throw new SocSecException("wrong number of characters");
		}
		
		for (int i = 0; i < ssn.length(); i++) {
			char currentCharacter = ssn.charAt(i);
			
			if ((currentCharacter < 48 || currentCharacter > 57) && !(currentCharacter == '-')) {	// Compares ASCII values to determine non-digits (except hyphens)
				throw new SocSecException("contains a character that is not a digit");
			} else if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {	// Checks for hyphen in appropriate indexes
				throw new SocSecException("dashes at wrong positions");
			}
		}
		
		return true;
	}
}
