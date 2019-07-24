/**
 *
 */
package com.uks.shubham.core.day4;
import java.util.StringTokenizer;
/**
 * @author: 	Shubham Bujurge
 * Created Date:09/05/2019 11:20 AM
 * Assignment:  Day 3
 * Task: 		String Tokenizer
 *
 */
public class TestStringTokenizer {

	void displayColumn(String strInput){
		if(strInput != null){
			StringTokenizer st = new StringTokenizer(strInput,",");
			while(st.hasMoreElements())
				System.out.println(st.nextElement());
		}
	}
}
