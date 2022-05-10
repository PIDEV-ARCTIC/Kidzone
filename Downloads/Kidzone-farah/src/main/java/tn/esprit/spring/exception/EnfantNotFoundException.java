package tn.esprit.spring.exception;

public class EnfantNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2533194229906054487L;
	
	public EnfantNotFoundException(String message) {
		super(message);
	}

}
