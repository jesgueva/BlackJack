package proejct4CardGame;

//We are not using serialized objects
@SuppressWarnings("serial")
public class DuplicateCardException extends RuntimeException {
	/**
	 * 
	 */
	

	public DuplicateCardException() {
		super ();
	}
	
	public DuplicateCardException(String message) {
		super (message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
