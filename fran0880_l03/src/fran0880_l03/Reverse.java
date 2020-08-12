package fran0880_l03;

import java.util.Scanner;

public class Reverse {

    public static void main(String args[]) {
    	System.out.println("Input Message:");
    	System.out.println("==============");
        System.out.println(" ");
    	 Scanner s = new Scanner(System.in);
    	 if(s.hasNextLine()) {
    		 String reverse = new StringBuilder(s.nextLine()).reverse().toString();
    		 System.out.println(reverse);
    		 
    	 }
    	 
        s.close();
}
}
