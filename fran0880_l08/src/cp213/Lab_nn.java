package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab to test various exceptions.
 *
 * @author David Brown
 * @version 2017-06-19
 *
 */
public class Lab_nn {

    /**
     * @param args
     *            unused default parameter
     */
    public static void main(final String[] args) {

	   try {
	                                       // insert bad code here
	      int n = 0;
	                                       // ArithmeticException
	    
	      n = 1 / 0;
	      System.out.println("n: " + n);
	                                       // NumberFormatException
	      n = Integer.parseInt("Schwarzenegger");
	      System.out.println("n: " + n);
	                                       // ArrayIndexOutOfBoundsException
	      final int[] values = new int[5];
	      values[6] = 0;
	                                       // NullPointerException
	      final String s = null;
	      final boolean result = s.equals("David");
	      System.out.println(result);
	                                       // IllegalStateException
	      final Scanner keyboard = new Scanner(System.in);
	      keyboard.close();
	      keyboard.next();
	                                       // FileNotFoundException
	      final Scanner file = new Scanner(new File("nonexistant.txt"));

	      while (file.hasNext()) {
		     System.out.println(file.next());
	      }
	      file.close();

	   } catch (final FileNotFoundException e) {
	       System.out.println("FileNotFoundException: file 'nonexistant.txt' does not exist");
	    
	   } catch (final IllegalStateException e) {
	       System.out.println("IllegalStateException: cannot use closed Scanner object");
	    
	   } catch (final NullPointerException e) {
		   System.out.println("NullPointerException: string cannot be null");
		
	   } catch (final ArrayIndexOutOfBoundsException e) {
	       System.out.println("ArrayIndexOutOfBoundsException: index 6 is too large");
	    
	   } catch (final ArithmeticException e) {
	       System.out.println("ArithmeticException: Division by zero");
	    
	   } catch (final NumberFormatException e) {
	       System.out.println("NumberFormatException: Schwarzenegger is not a number");
	    
	   } catch (final Exception e) {
	                                        // generic exception/error catching
	       System.err.println(">>> Caught Exception :::::::::::::::::::::::::::::::::::::::::::::");
	       System.err.println("getMessage()         : " + e.getMessage());
	       System.err.println("getLocalizedMessage(): " + e.getLocalizedMessage());
	       System.err.println("toString()           : " + e);
	       System.err.println(""); 
	       System.err.println("printStackTrace()    : \n" +
	    		           "=====================");
	       e.printStackTrace();
	    
	   } finally {
	                                        // code to always be executed when try block ends
	       System.out.println();
	       System.out.println("End of program");
	   }
    }
}
