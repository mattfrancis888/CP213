package cp213;
/**
 * Inherited class in simple example of inheritance / polymorphism.
 * 
 * This class defines a Road Bike by extending the Bicycle Base Class by specifying
 * the number of gears/speeds that the bike has.
 *
 * @author  Rick Magnotta
 * @version 2019-11-19
 */
public class RoadBike extends Bicycle {
	 private int hi;
	 private int max_gears;                   // Maximum number of gears on the bike.
	
	 public RoadBike() {
		 //default constructor
		 this(10);                            // Default of a max. of 10 gears.
	 }
	 
	 public RoadBike(int max_gears) {         // Initialize in First gear and Stopped (speed = 0.0)
	 	super(1,0);
		this.max_gears = max_gears;
	 }
	  	 
    @Override
	 public void print() {
		 System.out.println("Road Bike:: Number of Speeds = [" + max_gears +"]");
		 super.print();
	 }
    
    @Override
    protected void shiftUp(int nsteps) {
    	System.out.println("::: Attempt shiftUp["+ nsteps +"])");
    	int curr_gear = this.getGear();
    	if(curr_gear + nsteps <= this.max_gears) {
    		super.shiftUp(nsteps);
    	} else { 
    		super.shiftUp(this.max_gears - curr_gear);
    	}
    }
}
