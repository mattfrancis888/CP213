package fran0880_l02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileTest {
	
	/**
	 * Reads file from Scanner class and prints every token
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\CP213\\fran0880_l02\\src\\fran0880_l02\\ScannerTest.java");
        Scanner source = new Scanner(file);
        int count = 0;
        while (source.hasNext()) {
        	count+=1;
        	String word = source.next();
        	System.out.println(word);
      
        }
        System.out.println("Number of lines: " + count);
        source.close();
	}

}