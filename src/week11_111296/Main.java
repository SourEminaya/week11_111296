package week11_111296;
import java.util.*;
public class Main {
	public static boolean checkPassword(String str) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    boolean stringlen = false;
	    if(str.length()>=6 && str.length()<=16) {
	    	stringlen=true;
	    }
	    for(int i=0;i < str.length();i++) {
	        ch = str.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag && stringlen);
	            return true;
	    }
	    return false;
	}
	public static boolean checkUsername(String str) {
		boolean stringlen=false;
		if(str.length()>=8) stringlen=true;
		if (stringlen) {
			return true;
		} else
			return false;
	}
	public static void initialize (ArrayList<User> list) {
		String fname="John";
		String lname="Doe";
		char gender='L';
		String addr="Jl. Merpati No. 1 RT 1 RW 1, Banten";
		String uname="admin";
		String password="admin";
		User newUser= new User(fname,lname,gender,addr,uname,password);
		list.add(newUser);
	}
	public static void login(ArrayList<User> list) throws ExcessiveFailedLoginException{
		String uname;
		String pw;
		Scanner sc = new Scanner(System.in);
		System.out.println("Masukkan username: ");
		uname=sc.nextLine();
		System.out.println("Masukkan password: ");
		pw=sc.nextLine();
		for(User i: list) {
			boolean check=i.login(uname, pw);
			System.out.println(i.getUsername());
			if (check) {
				System.out.println(i.greeting());
			}
		}
		
	}
	public static void signup(ArrayList<User> list) {
		Scanner sc = new Scanner(System.in);
		boolean userCreated=false;
		while (userCreated==false) {
			System.out.println("Nama depan: ");
			String fname=sc.nextLine();
			System.out.println("Nama belakang: ");
			String lname=sc.nextLine();
			System.out.println("Username: ");
			String uname=sc.nextLine();
			if (checkUsername(uname)==false) {System.out.println("Username harus melebihi 8 karakter"); break;}
			System.out.println("Gender: ");
			String gen=sc.nextLine();
			char g=gen.charAt(0);
			System.out.println("Alamat: ");
			String addr=sc.nextLine();
			System.out.println("Password: ");
			String pw=sc.nextLine();
			if (!checkPassword(pw)) {System.out.println("Password harus mengandung huruf besar, huruf kecil, angka, minimal 8 karakter, dan maksimum 16 karakter"); break;}
			User newUser = new User(fname,lname,g,addr, uname,pw);
			list.add(newUser);
			userCreated=true;
		}
	}
	

	public static void main(String[] args) throws ExcessiveFailedLoginException{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		ArrayList <User> list = new ArrayList<User>();
		initialize(list);
		int mainChoice=0;
		while (mainChoice!=3) {
			System.out.println("Welcome to login porta;\n1. Login\n2. Create new user\n3. Terminate");
			mainChoice=sc.nextInt();
			sc.nextLine();
			switch(mainChoice) {
			case 1:
				login(list);
				break;
			case 2:
				signup(list);
				break;
			case 3:
				break;
			default:
				System.out.println("Input salah, masukkan ulang input");
					
				
			}
		}

	}

}
