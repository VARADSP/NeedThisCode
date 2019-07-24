/**
 *
 */
package com.uks.shubham.core.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shubham
 *
 */
public class FrequencyChecker {

	@SuppressWarnings("rawtypes")
	void frequency(String[] strArray){
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0; i < strArray.length; i++)
			map.put(i, strArray[i]);

		for(Map.Entry m:map.entrySet()){
			System.out.println("word"+ m.getKey() + " " + m.getValue());
		}

		//For String Autoboxing
		/*int cnt = 1,inc;
		for(inc = 0 ;inc < strArray.length; inc++ ){
			System.out.println(str + cnt + " = " + strArray[inc] );
			cnt++;
		}*/
	}

}
