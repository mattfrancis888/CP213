package cp213;

public class CAS extends Professor implements Comparable<Person>  {
	String term = "201705";
	public CAS(String lastName, String firstName, String department) {
		super(lastName, firstName, department);
	}
	
	public static void main(final String[] args) {
		CAS a = new CAS("hi","bye","lol");
		a.print();
	 }
	
	
	
	  @Override
	    public void print() {
		// Prints contents of Professor as formatted string. Overrides Person
		// print().
//		System.out.println(this.lastName + ", " + this.firstName);
//		System.out.println("Department: " + this.department);
		 
		 //this.firstName is protected, so accecible
		 System.out.println(this.lastName + ", "+  this.firstName);
		 System.out.println("Department: " +  this.getDepartment());
		//this.department is private in Professor class, so I can't access it
		 //but the getter method is public so it's inherited
		 System.out.println("Term: " + this.term);
		 System.out.println(this.matt);
	    }

	  //2. Not possible:
	  //1. Changing interface to Comparable<CAS> would make java say:
	  //That you cannot have an itnerface with 2 types of argument
	  //Occurs because CAS inherits Person
	  //2. Term is inside CAS and not in Person; Person object can't access child vars
	    @Override
	    public int compareTo(final Person person) {
		// Compares two Person objects by lastName then firstName.

		int flag = this.firstName.compareTo(person.firstName);

		if (flag == 0) {
		    // first names are the same - compare terms.
		    flag = this.term.compareTo(person.term);
		}
		return flag;
	    }

	
	
}
