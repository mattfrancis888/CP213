package fran0880_l04;

public class EmployeeRecord {
	private String empName = "";
	private int empAge = 0;
	
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	@Override
	public String toString() {
		String string = String.format("Name: %s Age: %d %n",  getEmpName(), getEmpAge());
		return string;
	}
}
