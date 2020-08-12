package fran0880_l02;

import java.util.Scanner;
import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class ScannerTest {
	
	/**
	 * Main method prompts user for integers and displays error messages on invalid inputs
	 * @param args
	 */
	

    public static void main(String args[]) {
        System.out.println("Enter a series of integers. Press 'q' to quit.");
        // Read from the keyboard.
        Scanner s = new Scanner(System.in);
        int result = 0;
        String keepGoing= "a";
        while (!(keepGoing.equals("q"))) {
            
            if(s.hasNextInt()) {
            	result += s.nextInt();
      
            	
            } else {
            	
            	keepGoing = s.next();
            	System.out.println(keepGoing);
            }
            
        }
    
        s.close();
        System.out.println("The total is " + result);
    }
}