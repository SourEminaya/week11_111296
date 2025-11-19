package week11_111296;

public class ExceptionThrown {
	static int divideByZero(int a,int b) {
		int i=a/b;
		return i;
	}

	static int computeDivision(int a,int b) {
		int res=0;
		try {
			res=divideByZero(a,b);
		}
		catch(NumberFormatException ex) {
			System.out.println("NumberFormatException has occured.");
		}
		return res;
		
	}
	public static void main(String[] args) {
		int a=1;
		int b=1;
		try {
			int i=computeDivision(a,b);
		}catch(NumberFormatException ex){
			System.out.println(ex.getMessage());
		}
	}
}
