package cp213;
/**
 * Class to tabulate/record ALL life forms found on Earth.
 * @author Rick Magnotta
 * @param entity - Type of life form: Animal, Plant, etc.
 * @param name - Name given to the life form to classify/describe.
 */
public class LifeForm_2 extends LifeProperty implements DeathProperty_interface {
	private String entity;            // Kind of life form: Animal, Plant, etc.
	private String name;              // Name given to life form.
	private String process_name;

	LifeForm_2(String entity, String name) {
		this.entity = entity;
		this.name   = name;
	}
	
	/**
	 * Records the type of breathing mechanism used by the named life form.
	 * @param organ - Life form's breathing organ
	 * @param inhale_gas - Life form's substance/gas that it inhaled
	 * @param exhale_gas - Life form's substance/gas that it exhales
	 * @return this
	 */
    public void breathing_mechanism(String organ, String inhale_gas, String exhale_gas) {
       this.organ      = organ;
       this.inhale_gas = inhale_gas;
       this.exhale_gas = exhale_gas;
    }
    /**
     * Records the type of eating mechanism used by the named life form.
     * @param ingestion - Life form's type of eating mechanism.
     * @return this
     */
	public void eating_mechanism(String ingestion) {
		this.ingestion = ingestion;
	}
	/**
     * Records the type of pooping mechanism used by the named life form.
     * @param pooping - Life form's type of pooping mechanism.
     * @return this
     */
	public void pooping_mechanism(String pooping) {
		this.pooping = pooping;	
	}
	/**
     * Records the type of reproductive mechanism used by the named life form.
     * @param reproductive - Life form's type of reproductive mechanism.
     * @return this
     */
	public void reproductive_mechanism(String reproduction) {
		this.reproduction = reproduction;	
	}
	
	@Override
	public void describe() {
		super.describe();
		
		System.out.println();
		System.out.println(">>>> Organism Described by Class> LifeForm_2");
		System.out.println(":::>    Living Entity ==========> " + this.entity);
		System.out.println("   >    Name....................: " + this.name);
		System.out.println("   >    Breathing Mechanism: ");
		System.out.println("   >       Breathing Organ......: " + this.organ);
		System.out.println("   >       Inhale Substace......: " + this.inhale_gas);
		System.out.println("   >       Exhale Substance.....: " + this.exhale_gas);
		System.out.println("   >    Eating Mechanism........: " + this.ingestion);
		System.out.println("   >    Pooping Mechanism.......: " + this.pooping);
		System.out.println("   >    Reproductive Mechanism..: " + this.reproduction);
		System.out.println("   >    Decomposing Mechanism..: " + this.process_name);
		System.out.println();
	}

	@Override
	public void decomposing_mechanism(String process_name) {
		// TODO Auto-generated method stub
		this.process_name = process_name;
		
	}		
}
