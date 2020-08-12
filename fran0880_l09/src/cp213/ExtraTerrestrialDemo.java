package cp213;

/**
 * Demo Class to demonstrate the programming and use of Interfaces and Abstract Classes.
 * 
 * @author Rick Magnotta rmagnotta@wlu.ca
 * @version 2020-07-09.1
 *
 */
public class ExtraTerrestrialDemo {
	public static void main(String[] args) {
		 final String sep = "-------------------------------------------------------------";
		
		 System.out.println(sep);                        // LifeForm_1 Class used to classify
		                                                 // the "Animal" life form: "Elephant".
		 LifeForm_1 living_thingA1 = new LifeForm_1("Animal","Elephant");
		 
		 living_thingA1.breathing_mechanism   ("Lungs", "O2", "CO2");
		 living_thingA1.eating_mechanism      ("Swallow"   );
		 living_thingA1.pooping_mechanism     ("Defecation");
		 living_thingA1.reproductive_mechanism("Sexual"    );
		 living_thingA1.describe();
		 
		 System.out.println(sep);                        // "LifeForm_1 Class used to classify
                                                         // the "Plant" life form: "Oak Tree".
         LifeForm_1 living_thingP = new LifeForm_1("Plant","Oak Tree");
		 
		 living_thingP.breathing_mechanism   ("Leaf", "CO2", "O2");
		 living_thingP.eating_mechanism      ("Absorption" );
		 living_thingP.pooping_mechanism     ("None");
		 living_thingP.reproductive_mechanism("Asexual"    );
		 living_thingP.describe();
		 
/*=====================================================================================	*/	                                                   
		 System.out.println(sep);                        // LifeForm_2 Class used to classify
		                                                 // the "Animal" life form: "Mouse".
		 LifeForm_2 living_thingA2 = new LifeForm_2("Animal","Mouse");
		 
		 living_thingA2.breathing_mechanism    ("Lungs", "O2", "CO2");
		 living_thingA2.eating_mechanism       ("Swallow"     );
		 living_thingA2.pooping_mechanism      ("Defecation"  );
		 living_thingA2.reproductive_mechanism ("Sexual"      );
		 living_thingA2.decomposing_mechanism  ("Putrefaction");
		 living_thingA2.describe();
		 
		 System.out.println(sep);                        // Animal_3 Class used to classify
		                                                 // the "Animal" life form "Cat".
		 /*=====================================================================================*/
		 LifeForm_3 living_thingA3 = new LifeForm_3("Animal","Cat");
		 
		 living_thingA3.breathing_mechanism    ("Lungs", "O2", "CO2");
		 living_thingA3.eating_mechanism       ("Swallow"     );
		 living_thingA3.pooping_mechanism      ("Defecation"  );
		 living_thingA3.reproduction_mechanism ("Sexual"      );
		 living_thingA3.decomposing_mechanism  ("Putrefaction");
		 living_thingA3.describe();	  
/*====================================================================================*/
	}
}
