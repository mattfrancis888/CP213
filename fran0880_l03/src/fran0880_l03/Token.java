package fran0880_l03;

import java.util.Scanner;

public class Token {

    public static void main(String args[]) {
    	System.out.println("Enter a token. Enter 'Quit' to stop: ");
    	String keepGoing =  "a";
    	Scanner s = new Scanner(System.in);
    	while (!(keepGoing.equals("Quit"))) {
        	//While the user hasnt quit
    		//scanner checks for type of input
    		//then s.next() will move to the next input
                if(s.hasNextInt()){
                	
                    System.out.println("The token is of type ..............: Integer");
                    keepGoing = s.next();
                } else if (s.hasNextFloat()) {
                	System.out.println("The token is of type ..............: Float");
                	keepGoing = s.next();
                } else if (s.hasNextDouble()) {
                	System.out.println("The token is of type ..............: Double");
                	keepGoing = s.next();
                } else if (s.hasNextBoolean()) {
                	System.out.println("The token is of type ..............: Boolean");
                	keepGoing = s.next();
                } else if (s.hasNextLong()) {
                	System.out.println("The token is of type ..............: Long");
                	keepGoing = s.next();
                }
                else if(s.hasNext()){
               	 System.out.println("The token is of type ..............: String");
                	keepGoing = s.next();
                }
               
               System.out.println("Enter a token. Enter 'Quit' to stop: ");
    		}
            

    	s.close();
    }
}
