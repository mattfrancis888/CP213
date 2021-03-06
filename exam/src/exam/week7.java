package exam;

public class week7 {
	
	//exceptions
	
	 public static void main(String[] args) {
		 //ioexception . This exception is related to Input and Output operations in the Java code. 
		 //This exception happens when there is a failure during reading, writing and searching file or directory operations.
//		 try{
		 //if( condition) throw new Exception(StringArgument);}
//		 catch(Exception e){
//			 		String message = e.getMessage();
//			 		System.out.println(message);
//			 		System.exit(0);
//		 } 
		 
		 //NumberFormatExcepiton =  NumberFormatException is an Exception that might be thrown when you try to convert a String into a numbe
		//ArithmeticException : Thrown when an exceptional arithmetic condition has occurred. For example, an integer "divide by zero" throws an instance of this class.
		 try {
			divideInt(1,0);
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //if try and catch is not used here, we can throw it via class. eg; class week7 throws DivideByZeroException, anotherexcetpion, etc
	 }
	 public class DivideByZeroException extends Exception {
		 public DivideByZeroException(String message) {
			 super(message);
		 }
		 public DivideByZeroException() {
			 super("test"); //if no argument is no given
		 }
	 }
	 
	 public static void divideInt(int i, int j) throws DivideByZeroException {
		 if(j == 0) throw new week7().new DivideByZeroException();
	 }
	 
	 
	 //if you have multiple catch blocks, the order is important, the first one that matches the type error is the one that is executed
	 //catch (Exception e){ . . . }catch (NegativeNumberException e) NegativeNumberException will never be executed	
	 
	 //derived class and exceptions
	 //when a derived class overides a method that throws an exception, the method should still throw that exception
	 //it cannot add additional exceptions
	 
	 //nested try catch blocks
	 //if you have it, make sure the names are different
	 //if the inner try catch dosent catch the error, the outer one will.
	 
	 //assertionError - when a program contains an assertion check and it fails. It is an unchecked exception, so a try catch block will not catch it
	 
	 //finaly in try catch finally: will alwyas be executed
	 
	 //catch or declare rule: catch the exception or declare the error by using throws clause
	 //checkede ecepiton: excepiton which are checked at compile time (eg; ClassNotFoundException, I/O exception); a try catch block must be declared so that it can be catched
	 //unchecked exception: exception which are NOT CHECKED at compile item (eg; user input, null exception, array index out of bound,)
	 //; are exempt from try catch block because java can't catch it at compile time
	 
	 //what happens if an exception is never caught? 
	 //in  a gui program , nothing happens, but the gui might be unreliable
	 //in a non gui program,will cause the program to terminate with an error message
	 
}
