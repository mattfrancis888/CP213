package cp213;
/**
 * Abstract Class to define the "Death" properties/mechanisms common to ALL life forms on Earth.
 * @author Rick Magnotta
 *
 */
public abstract class DeathProperty{
	protected String decomposition;     // Putrefaction, decomposition
	/**
	 * Abstract method to characterize the decomposing mechanism of the life form.		
	 * @param process_name
	 */
	public abstract void decomposing_mechanism(String process_name);
	
	public void describe() {
		System.out.println();
		System.out.println("===> DeathProperty is characterized by the presence of:");
		System.out.println("   >   1) A Decomposing Mechanism"   );
		System.out.println();
	}
}
