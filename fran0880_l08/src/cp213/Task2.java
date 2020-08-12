package cp213;
import java.util.Scanner;

public class Task2 {
	public static void main(String[]args) {
		Scanner keyboard = new Scanner(System.in);
		String str = "";
		int n = 0;
		System.out.print("Enter String to repeat: ");
		str = keyboard.nextLine(); 	//read entire line
		System.out.print("Repetitions...........: ");
		n = Integer.parseInt(keyboard.nextLine()); 	//read entire line
		try {
			Task2.StringPrinter(n, str);
		}catch(Exception e){
			e.printStackTrace();
		}
		keyboard.close();

	}
	/* prints the string n amount of times
	 * @n represents the number of times you want to repeat
	 * @str represents the str you want to repeat 
	 * */
	 
	   public static String StringPrinter(int n, String str) throws Exception{
		   //n is the number of times you want to repeat
		   //str is the stirng you want to repeat
	
			String finalString = "";
			if(n < 0) {
				throw new Exception("\r\n" + 
						"Please Enter a Positive Integer!");
			}
			for(int i = 0; i < n; i++) {
				finalString += str;
			}
			System.out.println("Final String..........: " + finalString);
			return finalString;
	   }
}
