package fran0880_l04;

import java.util.Scanner;
/**
 * Driver class to test the operation of the "Rectangle" class.
 * @author rmagnotta
 *
 */
public class RectangleDemo {
	
	public static void main(final String args[]) {
		
	   final Scanner keyboard = new Scanner(System.in);       // Read from the keyboard.
	  
       float  length;         // length of rectangle.
       float  width;          // width  of rectangle.
       double area;           // area   of rectangle.
       String conv;           // Conversion indicator (3 choices):
                              //    "ci" - values given are in centimeters => convert to inches
                              //    "ic" - values given are in inches      => convert to centimeters
                              //    "x"  - values given have no units      => no conversion.
	
	   System.out.println();
	   System.out.println("Area of a Rectangle Calculation & Units Conversion");
	   System.out.println("==================================================");
	   System.out.println();
	                                                         // Get length of rectangle
	   System.out.print("Enter the length (-1 to quit)   : ");
	   length = keyboard.nextFloat();
	   
	   while ( length >= 0 ) {                               // Keep asking for input until length is -ve!
		   System.out.print("Enter the width                 : ");
		   width = keyboard.nextFloat();	
		   
		   System.out.print("Enter the conversion [ci, ic, x]: ");
		   conv = keyboard.next();
		       
		   if ( conv.equals("ci") ) {
			                               // Calculate area and convert result from centimeters to inches.
		  	  area = Rectangle.area(width, length, conv);
		      System.out.printf("==> Area of rectangle is .......: [%10.3f] sq. inches", area);
		      System.out.println();
		      
		   }else if ( conv.equals("ic") ) {
			                               // Calculate area and convert result from inches to centimeters.
		   	  area = Rectangle.area(width, length, conv);
		   	  System.out.printf("==> Area of rectangle is .......: [%10.3f] sq. centimeters", area);

		      System.out.println();
		   
		   }else if ( conv.equals("x") ) {
			                               // Calculate area, but no conversion requested.
			  area = Rectangle.area(length, width);
			  System.out.printf("==> Area of rectangle is .......: [%10.3f]", area);
			   System.out.println();
		   }else {
			                               // Ooops, invalid conversion factor entered.
		   	  System.out.println(">>> Invalid conversion factor   : [" + conv + "]");
		   }
		  	                               // Ask for the next rectangle to process.
		   System.out.println();
		   System.out.print("Enter the length (-1 to quit)   : ");
		   length = keyboard.nextFloat();
	   }
	  	                                   // Always a good idea to indicate end of execution.
	  System.out.println();
	  System.out.print(":::> Program Terminated ");
	  keyboard.close();
   }
}
