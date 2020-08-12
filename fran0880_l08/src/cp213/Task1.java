package cp213;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		int user_num;
		boolean loop = true;
		while (loop)
		{
			System.out.print("Enter an Integer: ");
			try
			{
				user_num = in.nextInt();
				System.out.println("You typed.......: " + user_num+"\n");
			} catch (InputMismatchException ime)
			{
				if (!in.hasNext("quit"))	
					System.out.println(">>> That is not an Integer!\n");
				else
					loop = false;
				in.next();
			}
		}
		in.close();
		System.out.println("::: End Program");
	}
}
