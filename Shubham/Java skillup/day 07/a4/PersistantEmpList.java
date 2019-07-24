package com.jvs.uks.day07.a4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:15/05/2019 03: 21 PM
 * Assignment:  Day 7
 * Task:  serialization and de-serialization
 *
 */
public class PersistantEmpList implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;	//serialVesrionId is created for the checking each time calling the object and thats uniq ID

	public static void main(String[] args){
		String name;
		int age;
		double basicsal;
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of Employees ");
		int num = scan.nextInt();

		Hashtable<Integer, EmployeeDetail> obj = new Hashtable<Integer, EmployeeDetail>();	//creating HasTable with Key and value pair, 2nd is Class object
		for(int i = 0; i < num; i++){
			System.out.print("Enter name: ");
			name=scan.next();
			System.out.print("Enter age: ");
			age=scan.nextInt();
			System.out.print("Enter Basic salary: ");
			basicsal=scan.nextDouble();
			obj.put(i+1, new EmployeeDetail(name,age,basicsal));	//Adding each obj to hashTable
		}
		try{
			serialized(obj);	//Calling serialized
			deserialized();		//Calling deserialized
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			scan.close();
		}
	}

	//Serialization of the data
	private static void serialized(Hashtable<Integer, EmployeeDetail> emp) {
		try{
			 System.out.println("serialization process started");
			//Saving of object in a file
	        FileOutputStream file = new FileOutputStream("D:\\temp.txt");
	        ObjectOutputStream out = new ObjectOutputStream(file);

	        // Method for serialization of object
	        out.writeObject(emp);

	        //closing objects of file and object
	        out.close();
	        file.close();

	        System.out.println("serialization process ended");

		}
		catch(Exception e){
			System.out.println("IOException is caught");
		}
	}

	//Deserialization of the data
	private static void deserialized() {
		ObjectInputStream input;
		try{
			System.out.println("deserialization Process Started");
			input = new ObjectInputStream(new FileInputStream("D:\\temp.txt"));
			@SuppressWarnings("unchecked")
			Hashtable<Integer, EmployeeDetail>emp = (Hashtable<Integer, EmployeeDetail>) input.readObject();
			EmployeeDetail employee;
			//Reading the total objects of the employee
			for (Entry<Integer, EmployeeDetail> entry : emp.entrySet()) {
				employee = entry.getValue();
				System.out.println(employee.name + " " + employee.age + " " + employee.basicsal);
			}

			System.out.println("deserialization process ended");
			//closing objects of file and object
			input.close();
		}
		catch(Exception e){
			System.out.println("IOException is caught");
		}

	}

}
