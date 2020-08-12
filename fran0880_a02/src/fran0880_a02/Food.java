package fran0880_a02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
/**
 * The Food class definition.
 * 
 * @author Matthew Francis
 * @version 2020-06-05
 */
public class Food implements Comparable<Food> {
	public static void main (String[]args) throws FileNotFoundException {
		
		Food food = new Food("Ravioli",7,false, 246);
		System.out.println("Food key: " + food.key());
		Food food2 = new Food("Ravioli",9,false, 246);
		System.out.println("Compare to: " + food.compareTo(food2));
		System.out.println("Name: " + food.getName());
		System.out.println("Origin: " + food.getOrigin());
		System.out.println("Vegetarian: " + food.isVegetarian());
		System.out.println("Calories: " + food.getCalories());
		System.out.println("Hash: " + food.hashCode());
		System.out.println("getOriginString: " + food.getOriginString());
		
	 	OutputStream output = new FileOutputStream("C:\\CP213\\fran0880_a02\\src\\fran0880_a02\\foodWrite.txt");
    	PrintStream printStream = new PrintStream(output);
    	food.write(printStream);
    	System.out.println("Written to txt file");
    	
    	
		
		
	}
    // Constants
    public static final String ORIGIN[] = { "Canadian", "Chinese", "Indian",
	    "Ethiopian", "Mexican", "Greek", "Japanese", "Italian", "American",
	    "Scottish", "New Zealand", "English" };

    /**
     * Creates a string list of food origins in the format
     * 
     * <pre>
     * 0 Canadian 
     * 1 Chinese 
     * 2 Indian
     * ...
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String origins() {
	// your code here

      	String result = "";
        	for(int i = 0; i < ORIGIN.length; i++) {
       		result += i + " " + ORIGIN[i] + "\n";
        	}
        	return result;
    }

    // Attributes
    private String name = "";
    private int origin = 0;
    private boolean vegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name
     *            food name
     * @param origin
     *            food origin code
     * @param vegetarian
     *            whether food is vegetarian
     * @param calories
     *            caloric content of food
     */
    public Food(final String name, final int origin, final boolean vegetarian,
	    final int calories) {
			this.name = name;
			this.origin= origin;
			this.vegetarian= vegetarian;
			this.calories = calories;
	
    }

    /*
     * (non-Javadoc) Compares this Food against that Food. Returns -1 if this Food
     * comes before that Food, 1 if this Food comes after that Food, and 0 if
     * the two Foods are the same.
     * 
     * Foods are compared first by name, then by origin.
     *
     * @see java.lang.Comparable//compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Food that) {
//    	if(this.getOrigin == that.getName() ) {
//    		
//    	}
//    	else if(this.getOrigin() < that.getOrigin()) {
//		;
//		}
//		else if(this.getOrigin() > that.getOrigin()){
//			return - 1
//		}
    	int result;
    	result = that.getName().compareTo(this.getName());
    	if(result == 0) {
    		result = Integer.compare(that.getOrigin(), this.getOrigin());

    	}
    	
    	if (result > 0) result = 1;
    	else if (result < 0) result = -1;
  
    	return result;
    	
	// your code here

    }

    /**
     * @return calories
     */
    public int getCalories() {

	// your code here
    	return this.calories;
    	
    }

    /**
     * @return name
     */
    public String getName() {

	// your code here
    	return this.name;
    }

    /**
     * @return origin
     */
    public int getOrigin() {

	// your code here
    	return this.origin;

    }

    /**
     * @return the string version of origin
     */
    public String getOriginString() {

	// your code here
    	return Integer.toString(this.origin);
    }

    /*
     * (non-Javadoc) Generates a hash value from a food name.
     *
     * @see java.lang.Object//hashCode()
     */
    @Override
    public int hashCode() {
    
//    	return this.name.hashCode();
	// your code here
    	int hashed = 0;
        for (int i = 0; i < this.name.length(); i++) {
            
            
            hashed +=  ((this.name.charAt(i)) *  Math.pow(31,  this.name.length()-i-1) );  
        }
        return hashed;
    }

    /**
     * @return vegetarian
     */
    public boolean isVegetarian() {

	// your code here
    	return this.vegetarian;

    }

    /**
     * Creates a formatted string of food key data.
     *
     * @return the contents of Food as a key string.
     */
    public String key() {
    
    	
	// your code here
    	return String.format("%d:  %s %n", this.origin, this.name);

    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food
     * data.
     */
    @Override
    public String toString() {
	String string = String.format("Name:       %s%n", this.name);
	string += String.format("Origin:     %s%n", Food.ORIGIN[this.origin]);
	string += String.format("Vegetarian: %s%n", this.vegetarian);
	string += String.format("Calories:   %d%n", this.calories);
	return string;
    }

    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|vegetarian to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {
	final String string = String.format("%s|%s|%b|%d", this.name,
		this.origin, this.vegetarian, this.calories);
	ps.println(string);
	return;
    }

}