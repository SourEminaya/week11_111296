package week11_111296;

public class InvalidPropertyException extends Exception{
	public InvalidPropertyException() {
		super("Input Data Tidak valid");
	}
	public InvalidPropertyException(String msg) {
		super(msg);
	}

}
