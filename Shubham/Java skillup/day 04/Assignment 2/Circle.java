/**
 *
 */
package com.jvs.uks.day04;

import java.util.Scanner;

/**
* @author: 	Shubham Bujurge
* Created Date:10/05/2019 09: 47 AM
* Assignment:  Day 4
* Task: Basic of inheritance
 *
 */
public class Circle {

	/**
	 * @param args
	 */
	final static double PI = 3.14;
	public static void main(String[] args) {
		double radius;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius of circle:");
		Circle objCircle = new Circle();
		if(sc.hasNextLong()){		//number is long then execute
			radius = sc.nextLong();
			System.out.println("Area of circle for :" + objCircle.areaOfCircle(radius));
		}
		else if(sc.hasNextDouble()){	//number is double then execute
			radius = sc.nextDouble();
			System.out.println("Area of circle fro :" + objCircle.areaOfCircle(radius));
		}
		sc.close();
	}

	// Calculate the area of circle for double
	public double areaOfCircle(double rad){
		double ar;
		ar = PI * rad * rad;
		return ar;
	}
	// Calculate the area of circle for long
	public double areaOfCircle(long rad){
		double ar;
		ar = PI * rad * rad;
		return ar;
	}
}
