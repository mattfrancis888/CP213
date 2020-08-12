package fran0880_a01;

import java.util.Scanner;

public class Valid {

    public static void main(String args[]) {
    	
    	String s = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a string: ");
	
		s = keyboard.nextLine(); 	//read entire line
		
		while(s!= " ") {	
			//if there is a user input, keep asking
			if(isValid(s)) {
				System.out.println("'"+s+"' is a valid Java name.");
			} else {
				System.out.println("'"+s+"' is not a valid Java name.");
			}	
			
			System.out.print("Enter a string: ");
			
			s = keyboard.nextLine(); //read entire line
			
		}
		keyboard.close();
    	
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must
     * start with a letter or an underscore, but cannot be an underscore alone.
     * The rest of the variable name may consist of letters, numbers and
     * underscores.
     *
     * @param name
     *            a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
    
    	//Is first characther permissable
    	//symbols, digits, etc are NOT permissable
    	if(!Character.isJavaIdentifierStart(name.charAt(0))) {
    		return false;
    	}
    	
    	//_ is not valid; but __ is valid
    	if(name.charAt(0) == '_' && name.length() ==1) {
    		return false;
    	}
    	
    	//symbols, digits, etc are not permissable wheteher in
    	//a var
    	for (int i = 0; i < name.length(); i++) {
			if(!Character.isJavaIdentifierPart(name.charAt(i))) {
				return false;
			}
		}
    	
    	if(name.isEmpty()) {
    		return false;
    	}
 

    	return true;
    }
    	
    }
