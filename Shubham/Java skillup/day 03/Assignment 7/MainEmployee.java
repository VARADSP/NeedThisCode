/**
 *
 */
package com.jvs.uks.day03;

/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 05:10 PM
 * Assignment:  Day 3
 * Task: 		Employee
 *
 */
public class MainEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 2){
			double  salary = Integer.parseInt(args[1]);
			String name = args[0];
			if(!name.isEmpty() && salary > 0){
				Employee eObj = new Employee();
				eObj.setName(name);
				System.out.println("Name of the empolyee: "+eObj.getName());
				Employee.SalaryStructure sObj = new Employee.SalaryStructure();
				sObj.setSalary(salary);
				System.out.println("Basic salary: "+sObj.getSalary());
				System.out.println("Total HRA: "+sObj.hra());
				System.out.println("Total Salary: "+ sObj.totalSalary());
			}
		}
	}

}
