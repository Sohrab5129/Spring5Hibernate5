package spring5Hiberante5.bean;

public class LoginFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginFailedException(String message) {
		System.out.println(message);
	}

}
