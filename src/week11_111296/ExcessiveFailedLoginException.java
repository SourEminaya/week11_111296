package week11_111296;

public class ExcessiveFailedLoginException extends Exception{
	public ExcessiveFailedLoginException() {
		super("Anda telah mencapai jumlah batas login");
	}
	public ExcessiveFailedLoginException(String msg) {
		super(msg);
	}

}
