package cp213;
/**
 * Abstract Class to define the "Life" properties/mechanisms common to ALL life forms on Earth.
 * @author Rick Magnotta
 *
 */
public abstract class LifeProperty {
	protected String organ;             // Lungs, Gills, etc.
	protected String inhale_gas;        // O2, etc.
	protected String exhale_gas;        // CO2, etc.
	protected String ingestion;         // Swallow, Absorption, pinocytosis, phagocytosis, etc.
	protected String pooping;           // Excretion of waste: Defecation, transpiration, guttation, diffusion, etc.
	protected String reproduction;      // Sexual, Asexual, etc.
	/**
	 * Abstract method to describe the components of the breathing mechanism of the life form.	
	 * @param organ - Breathing organ.
	 * @param inhale_gas - Gas inhaled by organism
	 * @param exhale_gas - Gas exhaled by organism
	 */
	public abstract void breathing_mechanism(String organ, String inhale_gas, String exhale_gas);
	/**
	 * Abstract method to describe the eating mechanism of the life form.	
	 * @param ingestion - Type of eating mechanism
	 */
	public abstract void eating_mechanism(String ingestion);
	/**
	 * Abstract method to describe the waste removal mechanism of the life form.
	 * @param excretion - Type of pooping mechanism.
	 */
	public abstract void pooping_mechanism(String excretion);
	/** Abstract method to describe the reproductive mechanism of the life form.
	 * @param reproduction - Type of reproductive mechanism.
	 */
	public abstract void reproductive_mechanism(String reproduction);
	
	public void describe() {
		System.out.println();
		System.out.println("===> LifeProperty is characterized by the type of:");
		System.out.println("   >   1) A  Breathing Mechanism"   );
		System.out.println("   >   2) An Eating Mechanism"      );
		System.out.println("   >   3) A  Pooping Mechanism"     );
		System.out.println("   >   4) A  Reproductive Mechanism");
		System.out.println();
	}
}
