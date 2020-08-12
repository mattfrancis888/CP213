package cp213;
/**
 * Base class in simple example of inheritance / polymorphism.
 *
 * @author  Rick Magnotta
 * @version 2019-11-19
 */
public abstract class Bicycle {
    private int    gear;              // Gear that bike is traveling in.
    private double speed;             // Speed of bike.   
     /**
     * Constructor.
     * @param gear
     *            The gear that the bicycle is currently in.
     * @param speed
     *            The speed (in km/hr) that the bicycle is currently traveling at.
     */  
    protected Bicycle() {
    	//default constructor
    	this(1, 0.0);
    }
    
    protected Bicycle(int gear, double speed) {
    	this.gear  = gear;
       	this.speed = speed;
    }

    protected void setGear(int gear) {
    	this.gear = gear;
    }
    
    protected int getGear() {
    	return this.gear;
    }
    
    protected void setSpeed(double speed) {
    	this.speed = speed;
    }
    
    protected double getSpeed() {
    	return this.speed;
    }
    
    /** Shift DOWN "nsteps", where ONE step shifts down ONE gear.
     *  Able to check for, and prevent, chain derailment when Down Shifting.
     */
    protected void shiftDown(int nsteps) {
    	int curr_gear;                      // Current gear set on bike.
    	int new_gear;                       // New gear resulting after "nsteps" gear changes.
    	
    	if ( nsteps >= 0 ) {                // Only process positive values.
    	   curr_gear = this.getGear();
    	   new_gear  = curr_gear - nsteps;
    	   
    	   if ( new_gear < 1 ) {            // Clip down shift at 1, since cannot shift below lowest gear.
  	         new_gear = 1;
  	       }
    	   if (new_gear != curr_gear) {     // Change gear only if different than current gear.   	      
   		      this.setGear(new_gear);       // Bike is now set to "new_gear". 	
    	   }  
    	   System.out.println("::: shiftDown["+ nsteps +"] from Gear["+ curr_gear +"] ==> Final Gear = ["+ getGear() +"]");
    	}else {
    	   System.out.println(">>>ERR: shiftDown[" +nsteps +"]:: Only Positive shifts allowed!");  		
    	}
    }
    
    /**
     * Shift UP "nsteps", where ONE step shifts up ONE gear.
     * NOTE: Cannot check for, and prevent, chain derailment by not stepping past the highest gear.
     *       This is because the maximum number of available gears is not know in the base class. 
     */
    protected void shiftUp(int nsteps) {
    	int curr_gear;
    	int new_gear;
    	
    	if ( nsteps >= 0 ) {                // Only process positive values.
     	   curr_gear = this.getGear();
     	   new_gear  = curr_gear + nsteps;
     	   
     	   if (new_gear != curr_gear) {     // Change gear only if different than current gear.      
    		  this.setGear(new_gear);       // Bike is now set to "new_gear". 	
     	   }
    	   System.out.println("::: shiftUp["+ nsteps +"] from Gear["+ curr_gear +"] ==> Final Gear = ["+ getGear() +"]");
    	}else {
    	   System.out.println(">>>ERR: shiftUp[" +nsteps +"]:: Only Positive Shifts allowed!");
    	}
    }
        
    /**
     * Prints Gear and Speed of bike.
     */
    public void print() {
       System.out.println("::: gear[" +this.gear +"] ==> speed = [" +this.speed +"]Km/hr");
    }
}
