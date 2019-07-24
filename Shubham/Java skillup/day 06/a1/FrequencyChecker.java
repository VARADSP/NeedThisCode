/**
 *
 */
package com.jvs.uks.day06.a1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 3: 52 AM
 * Assignment:  Day 4
 * Task: 		Java map and collection
 *
 */
public class FrequencyChecker {

	@SuppressWarnings("rawtypes")
	void frequency(String[] strArray){
		Map<Integer, String> map = new HashMap<Integer, String>();	// map has the integer and string both parameters
		for(int i = 0; i < strArray.length; i++)
			map.put(i, strArray[i]);	//assign values to map  elements

		for(Map.Entry m:map.entrySet()){
			System.out.println("word"+ m.getKey() + " " + m.getValue()); //prints the map elements
		}

		//For String Autoboxing
		/*int cnt = 1,inc;
		for(inc = 0 ;inc < strArray.length; inc++ ){
			System.out.println(str + cnt + " = " + strArray[inc] );
			cnt++;
		}*/
	}

}
