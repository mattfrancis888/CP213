package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

/**
 * Process text files with three kinds of trees to determine their relative
 * efficiency.
 *
 * @author Matthew Francis
 * @version 2020-07-09
 */

public class A04 {
	
	static String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * Program for Assignment 4.
     *
     * @param args
     *            unused
     * @throws IOException
     *             If error on files.
     */
    public static void main(final String[] args) throws IOException {
    	
    	// ----------------------------------------------------------------------------
    	
    	// new file objects
    	
		
		File declineFile = new File("src/cp213/decline.txt");
    	File miserableFile = new File("src/cp213/miserables.txt");
    	File otoos610 = new File("src/cp213/otoos610.txt");
   
    	
    	// ----------------------------------------------------------------------------
    	
    	// new BST object
    	
    	
    	BST<Character> bst = new BST<Character>();
    	 
    	
    	// ----------------------------------------------------------------------------

    	// train a file into a BST
    	
    	
    	System.out.println("----------------------------------------------------------");
    	System.out.println("Tree Type: " + bst.getClass().getCanonicalName());
    	System.out.println("training...");	
    	train(bst, declineFile);
    	 
		
    	// ----------------------------------------------------------------------------
    	 

    	// creates a table that shows the character count in the tree
    	
    	
    	System.out.println("Training File: " + declineFile.getName());
    	System.out.println("Comparisons File: " + miserableFile.getName());
    	System.out.println("----------------------------------------------------------");		
    	characterTable(bst);
    	
    	
    	// ----------------------------------------------------------------------------

    	// tests if the BST is valid
    	
    	
    	System.out.println("----------------------------------------------------------");
    	System.out.println("Valid: " + bst.isValid());
    	
    	
    	// ----------------------------------------------------------------------------
    	
    	// prints BST root height
    	
    	
    	System.out.println("Valid: " + bst.getHeight());
    	 
    	
    	// ----------------------------------------------------------------------------

    	// prints # of comparisons made while retrieving characters from a BST
    	
    	
    	int bstComparisons = retrieve(bst, declineFile);
    	System.out.println("Comparisons: " + bstComparisons);
    
    	
    	// ----------------------------------------------------------------------------

    	// new PopularityTree<Character> object 
    	
    	
    	final PopularityTree<Character> pTree = new PopularityTree<Character>();
    	
    	
    	// ----------------------------------------------------------------------------

    	// train a file to a Popularity Tree
    	
    	
    	System.out.println("----------------------------------------------------------");
    	System.out.println("Tree Type: " + pTree.getClass().getCanonicalName());
    	train(pTree, declineFile);
    	
    	
    	// ----------------------------------------------------------------------------

    	// checks if the Popularity Tree is valid
    	
    
    	System.out.println("Valid: " + pTree.isValid());
    	
    	
    	// ----------------------------------------------------------------------------

    	// prints the Popularity Tree root node height
    	
    	
    	System.out.println("Height: " + pTree.getHeight());
    	
    	
    	// ----------------------------------------------------------------------------

    	// shows total comparisons made
    	
    	
    	int pTreeComparisons = retrieve(pTree, declineFile);
    	System.out.println("Comparisons: " + pTreeComparisons);
    	System.out.println("----------------------------------------------------------");
    	
    	
    	// ----------------------------------------------------------------------------

    	// shows which tree made less comparisons
    	
    
    	System.out.print("Tree with minimum comparisons: ");	
    	int result = Math.min(bstComparisons, pTreeComparisons); // returns minimum integer	
    	if (result == bstComparisons){
    		System.out.println("BST");
    	} 	
    	else {
    		System.out.println("Popularity Tree");
    	}
    	 
    	
    	// ----------------------------------------------------------------------------
    	
    	// puts a BST into an array in order
    	
    	
    	System.out.println("----------------------------------------------------------");
    	System.out.print("TreeNode<Character> array");
    	TreeNode<Character>[] array = bst.toArray();	
    	for (TreeNode node : array) {
    	    System.out.println(node.getData());
    	}
    	
    	
    }
    
    // ------------------------------------------------------------------------------

    /**
     * Print a formatted table of character counts and percentages.
     *
     * @param tree The BST to generate the table from.
     */
    public static void characterTable(final BST<Character> tree) {
      	float total = 0;
    	for (char character : ALPHA.toCharArray()) { // iterate through  alphabet
    	    if (tree.retrieve(character) != null) { // if the letter is in tree
    	    	total += tree.retrieve(character).getCount(); // retrieve the character and get the count
    	    }
    	}
    	System.out.print("Character Table for Training File\n\n");
    	System.out.print("Char   Count  Percent\n");
    	for (char character : ALPHA.toCharArray()) { 
    	    if (tree.retrieve(character) != null) { // if the letter is in  tree
        	    System.out.format("%4s%8d%9.2f\n", tree.retrieve(character).getData(),
        	    		tree.retrieve(character).getCount(), (tree.retrieve(character).getCount() / total) * 100);
    	    }
    	}
    }
    /**
     * Determine the number of comparisons to retrieve the contents of a file
     * from a tree. Reset the number of comparisons, then attempt to retrieve
     * every letter in the file from tree. All letters must be converted to
     * upper case.
     *
     * @param tree
     *            The BST to process.
     * @param file
     *            The file to process.
     * @return The number of comparisons necessary to find every letter in file
     *         in tree.
     * @throws FileNotFoundException
     *             Thrown if file not found.
     */
    public static int retrieve(final BST<Character> tree, final File file) throws FileNotFoundException {
    	tree.resetComparisons(); // resets comparisons count
    	final Scanner scan = new Scanner(file);
		String str = null; 
		while (scan.hasNextLine()){ 
			str = scan.nextLine().toUpperCase().replace("\\w", ""); // convert file line to upper case and remove the whitespace
			char[] characters = str.toCharArray(); // convert line into a character array
			
			for (char character : characters){ 
				if (Character.isLetter(character)){ // if the character is a letter
					tree.retrieve(character); // find character in the BST
											  // each time retrieving a character in the BST it updates the comparisons needed to find it
				}
			}
		}
		scan.close(); 
		return tree.getComparisons(); // return the comparisons count 
    }
    
    // ------------------------------------------------------------------------------
    
    /**
     * Train a tree by inserting all letters from a file into the tree. Letters
     * must be converted to upper-case. Non-letters are ignored.
     *
     * @param tree
     *            The BST to train.
     * @param file
     *            The file to read into the tree.
     * @throws FileNotFoundException
     *             Thrown if file not found.
     */
    public static void train(final BST<Character> tree, final File file) throws FileNotFoundException {
    	Scanner scan = new Scanner(file); 
		String str = null; 
		while (scan.hasNextLine()){ 
			str = scan.nextLine().toUpperCase().replace("\\w", ""); // turn characters into upper case and remove white space
			char[] characters = str.toCharArray(); 
			for (char character : characters){ // iterate through char array
				if (Character.isLetter(character)) { 
					tree.insert(character); // insert into the tree
				}
			}
		}
		scan.close();
	}
    
    // ------------------------------------------------------------------------------
  
 }
    