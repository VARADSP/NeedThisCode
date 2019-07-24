/**
 *
 */
package com.jvs.uks.day06.a1;

/**
 * @author: 	Shubham Bujurge
 * Created Date:13/05/2019 09: 50 AM
 * Assignment:  Day 5
 * Task: Search in Record
 *
 */
public class GeneralEmployee extends BaseEmployee {

	private String objectProperty;
	//GeneralEmployee parameterized constructor
	GeneralEmployee(String strArray, String first, String last, String emp, String basic) {
		super(strArray, first, last, emp, basic);
	}
	public GeneralEmployee getElement(){
		return(this);
	}

	//Getting GeneralEmployee elements
	public String getProperty(String colname){
		if(colname.equals("first")){
			objectProperty=this.firstName;
		}
		else if(colname.equals("last")){
			objectProperty=this.lastName;
		}
		else if(colname.equals("emp")){
			objectProperty=this.empType;
		}
		else if(colname.equals("empcode")){
			objectProperty=this.empCode;
		}
		else if(colname.equals("basic")){
			objectProperty=this.basicSalary;
		}
		else{
			System.out.println("Wrong input");
		}
		return objectProperty;
	}
}
