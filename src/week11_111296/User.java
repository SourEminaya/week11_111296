package week11_111296;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Formatter;
import week11_111296.ExcessiveFailedLoginException;
import week11_111296.InvalidPropertyException;


public class User {
	private String firstName;
	private String lastName;
	private Character gender;
	private String address;
	private String username;
	private String password;
	private MessageDigest digest;
	private static final int  maxLoginAttempts=3;
	private static int loginAttempts;
	
	public String hash(String toHash) {
		try {
			digest=MessageDigest.getInstance("SHA-256");
			byte[] hash=digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb= new StringBuilder();
			for(byte b: hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
	public User(String fname, String lname, Character g, String addr, String uname, String pw) {
		this.firstName=fname;
		this.lastName=lname;
		this.gender=g;
		this.address=addr;
		this.username=uname;
		this.password=hash(pw);
	}
	public boolean login(String uname, String pw) throws ExcessiveFailedLoginException{
		if(this.username.equals(uname)) {
			if(loginAttempts>=maxLoginAttempts) {
				throw new ExcessiveFailedLoginException();
			}
			if (this.password.equals(hash(pw))) {
				loginAttempts=0;
				return true;
			}else {
				System.out.println("Password yang anda masuki salah\nKesempatan anda memasukkan credential yang benar: "+ (maxLoginAttempts-loginAttempts)+" Kali lagi");
				loginAttempts++;
			}
		}
		return false;
		
	}
	public String greeting() {
		String greet="Selamat Datang.";
		switch(gender) {
		case 'L': {greet+= " Tuan "; break;}
		case 'P': {greet+= " Nona "; break;}
		default : {greet+= " Yang Terhormat "; break;}}
		greet+=this.firstName+" "+this.lastName;
		return greet;
	}
	public String getUsername() {
		return username;
	}

}
