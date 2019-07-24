/**
 *
 */
package com.jvs.uks.day03;
import java.util.StringTokenizer;
/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 11:20 AM
 * Assignment:  Day 3
 * Task: 		String Tokenizer
 *
 */
public class TestStringTokenizer {

	//this method accept string parameter
	void displayColumn(String strInput){
		if(strInput != null){
			StringTokenizer st = new StringTokenizer(strInput,",");	//separate the string by , separate value
			while(st.hasMoreElements())	//string has more elements checks
				System.out.println(st.nextElement());	//prints elements
		}
	}
}
