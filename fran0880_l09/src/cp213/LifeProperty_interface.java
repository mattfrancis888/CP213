package cp213;

public interface LifeProperty_interface{
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
	public abstract void reproduction_mechanism(String reproduction);
	
	/**
	 * 
	 * describes the object
	 */
	public void describe();
	
}
