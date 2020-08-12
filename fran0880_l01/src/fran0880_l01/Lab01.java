package fran0880_l01;

import java.util.Scanner;

public class Lab01 {
	public static void main (String[]args) {
		int a = 1;
		int b = 1;
		Scanner scan = new Scanner(System.in);
		
		while(a!=0 && b!=0) {
		
			System.out.print("Enter two integers seperated by a space. Enter 0 to quit: ");
			
			a = scan.nextInt();
			b = scan.nextInt();
			
			int gcd = gcd(a,b);
			
			System.out.println("The gcd for integers "+a+" and "+b+" is "+gcd);
		}
		scan.close();
		
	}
	
	public static int gcd(int a, int b) {
		int r;
		while(b!=0) {
			r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
