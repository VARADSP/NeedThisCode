/**
 *
 */
package com.jvs.uks.day04;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 3: 52 AM
 * Assignment:  Day 4
 * Task: 		Java map and collection
 *
 */
public class FrequencyChecker {

	public static void main(String[] args){
		try{
			FrequencyChecker objFrequencyChecker = new FrequencyChecker();
			objFrequencyChecker.frequency(args);
		}
		catch(Exception e)
		{
			System.out.println("Enter valid input");
		}
	}

	public void frequency(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();	// Hashmap has the integer and string both parameters
		int length = args.length;
		String[] unique = uniquekey(args);

		for(int i = 0; unique[i] != null;i++){
			int count =0;
			for(int j = 0; j < length; j++){
				if(unique[i].equals(args[j]))
					count++;
			}
			map.put(unique[i], count);
		}

		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = map.get(key).toString();
			System.out.println("Word ['"+key +"'] : " + value);
		}
	}

	private String[] uniquekey(String[] args) {
		String[] unique = new String[args.length];
		boolean keyValue = false;
		int index=1;
		unique[0]=args[0];

		for(int i=1;i<args.length;i++){
			for(int j=0;j<i;j++){
				if(args[j].equals(args[i])){
					keyValue=true;
					break;
				}
			}
			if(!keyValue){
				unique[index]=args[i];
				index++;
			}
			keyValue=false;
		}
		return unique;
	}

}
