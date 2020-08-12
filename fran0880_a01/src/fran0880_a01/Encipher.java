package fran0880_a01;

import java.util.Scanner;



public class Encipher {
    
	public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();
    public static final String CIPHERTEXT = "AVIBROWNZCEFGHJKLMPQSTUXYD";
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Testing 'shift' and 'substitute' Methods");
        System.out.println();

        int n = 0;

        System.out.println("Enter a string:");

        String s = keyboard.nextLine();
     
        while (s.length() > 0) {

        	System.out.print("Enter a shift length: ");
        	n = keyboard.nextInt();
        	keyboard.nextLine();
        	System.out.println("Shifted: " + shift(s, n));
        	System.out.println("Substitute: " + substitute(s, CIPHERTEXT));
        	System.out.println();
        	System.out.print("Enter a string: ");
        	s = keyboard.nextLine();
        }
    }




    /**
     * Encipher a string using a shift cipher.
     * 
     * @param s
     *            string to encipher
     * @param n
     *            the number of letters to shift
     * @return the enciphered string
     */

    public static String shift(String s, int n) {

        String temp_string = "";
        s = s.toUpperCase();

        for(int i = 0; i<s.length(); i++) {

        	if(!Character.isLetter(s.charAt(i))==false) {
        		temp_string += (char)(((char)s.charAt(i)+n-65)%26+65);
        	}
        	else
        		temp_string += s.charAt(i);
        }
        return temp_string;
    }


    /**
     * Encipher a string using the letter positions in ciphertext.
     * 
     * @param s
     *            string to encipher
     * @param ciphertext
     *            ciphertext alphabet
     * @return the enciphered string
     */

    public static String substitute(String s, String ciphertext) {

        int t;
        String temp_string = "";
        s = s.toUpperCase();
        
        for(int i=0; i<s.length();i++) {
        	if(!Character.isLetter(s.charAt(i))==false) {
	        	char charc = s.charAt(i);
	        	for(t=0; t<ALPHA.length(); t++) {

	        		char Alpha = ALPHA.charAt(t);

	        		if(charc == Alpha) {
	        			int x = t;
	        			temp_string += ciphertext.charAt(x);
	        		}
	        	}
        	}
        	else {
        		temp_string += s.charAt(i);
        	}
        }
        
        return temp_string;

    }

}

