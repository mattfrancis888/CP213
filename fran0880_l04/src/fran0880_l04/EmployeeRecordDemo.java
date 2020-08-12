package fran0880_l04;

import java.util.Scanner;

public class EmployeeRecordDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		EmployeeRecord emp1 = new EmployeeRecord();
		System.out.print("Enter first employee Name: ");
		emp1.setEmpName(input.nextLine());
		System.out.print("Enter first employee Age: ");
		emp1.setEmpAge(Integer.parseInt(input.nextLine()));
		
		EmployeeRecord emp2 = new EmployeeRecord();
		System.out.print("Enter second employee Name: ");
		emp2.setEmpName(input.nextLine());
		System.out.print("Enter second employee Age: ");
		emp2.setEmpAge(Integer.parseInt(input.nextLine()));
		
		if(emp1.getEmpAge() < emp2.getEmpAge()) {
			System.out.println(emp1);
		} else if(emp2.getEmpAge() < emp1.getEmpAge()) {
			System.out.println(emp2);
		} else {
			System.out.println(emp1);
			System.out.println(emp2);
		}
		input.close();
	}
}
