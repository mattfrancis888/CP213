package fran0880_a02;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Utilities for working with Food objects.
 *
 * @author Matthew Francis
 * @version 2020-06-05
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. (May assume foods is
     * not empty.)
     *
     * @param foods
     *            a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {
    	int average = 0;
    	int total = 0;
    	for (Food food:foods) {
    		total += food.getCalories();
    	}
    	average = total / foods.size();
    	return average;
    	
	// your code here

    }

    /**
     * Determines the average calories in a list of foods for a particular
     * origin.
     *
     * @param foods
     *            a list of Food
     * @param origin
     *            the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static double averageCaloriesByOrigin(final ArrayList<Food> foods,
	    final int origin) {
    	int average = 0;
    	int total = 0;
    	int length = 0;
    	for (Food food:foods) {
    		if(food.getOrigin() == origin) {
    			total += food.getCalories();
    			length += 1;
    		}
    		
    	}
    	average = total/length;
    	return average;
	// your code here

    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods
     *            a list of Food
     * @param origin
     *            a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods,
	    final int origin) {
    	
    	ArrayList<Food> foodList = new ArrayList<Food>();
     	for (Food food:foods) {
    		if(food.getOrigin() == origin) {
    			foodList.add(food);
    		}
    		
    	}
	// your code here
    	return foodList;

    }

    /**
     * Creates a Food object by requesting data from a user in the format:
     * 
     * <pre>
     * Name:
     * Origin:
     * Vegetarian (Y/N): 
     * Calories:
     * </pre>
     *
     * @param keyboard
     *            Scanner keyboard input
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {
    	System.out.println("Name: ");
    	String name = keyboard.nextLine();
    	System.out.println("Origin: ");
    	int origin = Integer.parseInt( keyboard.nextLine());
    	System.out.println("Vegetarian (Y/N): ");
    	boolean vegetarion = keyboard.nextLine().contentEquals("Y") ? true : false;
    	System.out.println("Calories: ");
    	int calories = Integer.parseInt(keyboard.nextLine());
    	
    	Food customFood = new Food(name, origin, vegetarion, calories );
    	return customFood;
    	
    	
	// your code here

    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods
     *            a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

	// your code here
      	ArrayList<Food> foodList = new ArrayList<Food>();
     	for (Food food:foods) {
    		if(food.isVegetarian()) {
    			foodList.add(food);
    		}
    		
    	}
     	return foodList;

    }

    /**
     * Test
     * 
     * @param args
     *            unused
     * @throws FileNotFoundException
     *             file not found
     */
    public static void main(final String[] args) throws FileNotFoundException {
    	
	// your code here
    	File file = new File("C:\\CP213\\fran0880_a02\\src\\fran0880_a02\\foods.txt");
 
    	ArrayList<Food> foodList = FoodUtilities.readFoods(file);
    	System.out.println("Avg cal: "+ FoodUtilities.averageCalories(foodList));
    	System.out.println("Avg cal by origin: "+ FoodUtilities.averageCaloriesByOrigin(foodList, 7));
    	System.out.println(" ");
    	System.out.println("Get food by origin:");
    	for (Food food:FoodUtilities.getByOrigin(foodList, 7)) {
    		System.out.println(food);
    	}
    	System.out.println(" ");
    	System.out.println("Get food by is vegetarian:");
    	for (Food food:FoodUtilities.getVegetarian(foodList)) {
    		System.out.println(food);
    	}
    	System.out.println(" ");
    	
    	Food customFood = FoodUtilities.getFood(new Scanner(System.in));
    	System.out.println(customFood );
    	System.out.println(" ");
    	System.out.println(FoodUtilities.readFood("Lasagna|7|False|135"));
    	
    	System.out.println(" ");
    	for (Food food:FoodUtilities.foodSearch(foodList, 1, 300, true)) {
    		System.out.println(food);
    	}
    	
   
    	//Create foodWrite.txt first then this code would write to the txt file
    	OutputStream output = new FileOutputStream("C:\\CP213\\fran0880_a02\\src\\fran0880_a02\\foodWrite.txt");
    	PrintStream printStream = new PrintStream(output);
    	FoodUtilities.writeFoods(foodList, printStream);
    	printStream.close();
    }

    /**
     * Creates and returns a food object from a line of string data.
     *
     * @param line
     *            a vertical bar-delimited line of food data in the format
     *            name|origin|vegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {
    	
    	//If the delimiter is a single character that is not a regular expression special character
    	//special character (i.e., not one of .$|()[{^?*+\) then you can use String.split
    	//Otherwise you need to do something like : \\|
    	String[] parts = line.split("\\|");
    	
    	String foodName = parts[0];
    	int origin = Integer.parseInt(parts[1]);
    	boolean isVege = Boolean.parseBoolean(parts[2]);
    	int calories =  Integer.parseInt(parts[3]);
 	   
 	   
 	    return new Food(foodName,origin,isVege, calories);


    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param file
     *            a file of Food
     * @return a list of Food
     * @throws FileNotFoundException
     *             file not found
     */
    public static ArrayList<Food> readFoods(final File file)
	    throws FileNotFoundException {

	// your code here
    	//TODO
    	ArrayList<Food> foodList = new ArrayList<Food>();
   
    	   Scanner source  = new Scanner(file);
    	   
    	   while (source.hasNextLine()) {
            	String[] parts = source.nextLine().split("\\|");
             	String foodName = parts[0];
            	int origin = Integer.parseInt(parts[1]);
            	boolean isVege = Boolean.parseBoolean(parts[2]);
            	int calories =  Integer.parseInt(parts[3]);
            	Food food = new Food(foodName,origin,isVege, calories);
            	foodList.add(food);
          
            }
    	    source.close();
		return foodList;
    	   
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods
     *            a list of Food
     * @param origin
     *            the origin of the food; if -1, accept any origin
     * @param maxCalories
     *            the maximum calories for the food; if 0, accept any
     * @param vegetarian
     *            whether the food is vegetarian or not; if false accept any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods,
	    final int origin, final int maxCalories, final boolean vegetarian) {

	// your code here
        ArrayList<Food> foodList = new ArrayList<Food>();
       for (Food food:foods) {
           if (origin == -1 && maxCalories == 0 && !vegetarian){
               return foods;
           }
           else if (origin==-1 && maxCalories == 0 && vegetarian == food.isVegetarian()){
               foodList.add(food);
           }
           else if(origin==-1 && food.getCalories() <= maxCalories && vegetarian == food.isVegetarian()){
               foodList.add(food);
           }
           else if(food.getOrigin() == origin && maxCalories == 0 && !vegetarian){
               foodList.add(food);
           }
           else if(food.getOrigin() == origin && food.getCalories() <= maxCalories && !vegetarian){
               foodList.add(food);
           }
           else if(food.getOrigin()  == origin && food.getCalories() <= maxCalories && food.isVegetarian() == vegetarian){
               foodList.add(food);
           }
        }
 
       return foodList;

    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     * @throws FileNotFoundException
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps)
	    throws FileNotFoundException {
		for (final Food food : foods) {
		    food.write(ps);
		}
    }
	
}
