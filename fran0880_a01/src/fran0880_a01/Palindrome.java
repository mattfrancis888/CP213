package fran0880_a01;
import java.util.Scanner;


public class Palindrome {

    public static void main(String[] args) {
		System.out.print("Enter a String: ");
		
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		isPalindrome(word);
        // test code here
    }

    /**
     * Determines if s is a palindrome. Ignores case, spaces, digits, and
     * punctuation in the string parameter s.
     *
     * @param s
     *            a string
     * @return true if s is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String s) {
        // method code here
    	  StringBuilder stuff = new StringBuilder();
    	    boolean condition = true;
    	   
    	       String[] words = s.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    	       //words returns a string that you are replacing in an array
//    	       for (String word: words) {
//    	    	   System.out.println(word);
//    	       }
    	       String delim = "";
    	       String word = String.join(delim,words);
    	       //Make string array to string
    	       
    	       stuff.append(word);
    	       stuff = stuff.reverse();
    	       
    	       if (word.equals(stuff.toString())) {
    	           condition = true;
    	           System.out.println(s + " is a palindrome");
    	       }
    	       else {
    	           condition = false;
    	           System.out.println(s + " is not a palindrome.");
    	       }
    	   
    	       return condition;
    }
}