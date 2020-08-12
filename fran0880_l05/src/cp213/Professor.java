package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author dbrown
 * @version 2017-06-09
 */
public class Professor extends Person {

    private String department = null;
    public String matt = "Matt";

    /**
     * @param lastName
     *            Professor last name (surname): defined in Person
     * @param firstName
     *            Professor first name (given name): defined in Person
     * @param department
     *            Professor department
     */
    public Professor(final String lastName, final String firstName,
	    final String department) {
	super(lastName, firstName);
	this.department = department;
    }

    /**
     * Getter for department.
     *
     * @return this.department
     */
    public String getDepartment() {
	return this.department;
    }

    @Override
    public void print() {
	// Prints contents of Professor as formatted string. Overrides Person
	// print().
	System.out.println(this.lastName + ", " + this.firstName);
	System.out.println("Department: " + this.department);
    }

}
