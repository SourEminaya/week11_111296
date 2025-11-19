package week11_111296;

public class AuthenticationException extends Exception {
	public AuthenticationException() {
		super("Anda telah mencapai batas jumlah login");
	}
	public AuthenticationException(String msg) {
		super(msg);
	}

}
