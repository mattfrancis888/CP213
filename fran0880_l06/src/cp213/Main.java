package cp213;

/**
 * Testing class in simple example of inheritance / polymorphism.
 *
 * @author  Rick Magnotta
 * @version 2019-11-19
 */
public class Main {

	public static void main(final String[] args) {
                                                // I have a 15 speed Road Bike called myBike.
		final RoadBike myBike  = new RoadBike();
		
		System.out.println();
		myBike.print();		
		System.out.println();
		
		myBike.shiftDown(3);
		System.out.println();
				
		myBike.shiftUp(10);
		System.out.println();

		myBike.shiftUp(-6);
		System.out.println();
		
		myBike.shiftUp(6);
		System.out.println();
		
		myBike.shiftUp(1);
		System.out.println();
		
		System.out.println("Program Ended ... till next time.");
	}

}
