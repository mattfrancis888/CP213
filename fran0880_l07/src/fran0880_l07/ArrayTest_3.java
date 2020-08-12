package fran0880_l07;

public class ArrayTest_3 {

	  public static void main(String[] args) {
	    int[] first = { 1, 3, 5, 7, 9 };
	    int[] second = first;

	    System.out.println("first:");

	    for (int i = 0; i < first.length; i++) {
	    	first[i] = first[i] * 2;
	      System.out.println(first[i]);
	    }

	    System.out.println("second:");

	    for (int i = 0; i < second.length; i++) {
	      System.out.println(second[i]);
	    }
	  }
	}

//Second array is also multiplied by 2