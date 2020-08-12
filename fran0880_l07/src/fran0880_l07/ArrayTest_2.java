package fran0880_l07;

public class ArrayTest_2 {

	  public static void main(String[] args) {
	    int[] first = { 1, 3, 5, 7, 9 };
	    int[] second = first;

	    System.out.println("first:");

	    for (int val : first) {
	      System.out.println(val);
	    }

	    System.out.println("second:");

	    for (int val : second) {
	      System.out.println(val);
	    }
	  }
	}