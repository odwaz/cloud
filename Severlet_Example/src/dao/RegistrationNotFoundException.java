package dao;

@SuppressWarnings("serial")
public class RegistrationNotFoundException extends Exception {

	public RegistrationNotFoundException(String reason) {
		super(reason);
	}

}
