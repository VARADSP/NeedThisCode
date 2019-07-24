/**
 *
 */
package com.jvs.uks.day02;
import java.lang.ProcessBuilder;
import java.util.Map;
import java.util.Set;
/**
 * @author: 	Shubham Bujurge
 * Created Date:08/05/2019 09: 55 AM
 * Assignment:  Day 2
 * Task: 		Runtime Test
 *
 */
public class RuntimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//creating a process Builder
		ProcessBuilder objPB = new ProcessBuilder();
		objPB.command("notepad.exe","the-file-name.txt");	//Opening Note-pad and writing on the file
		objPB.start();

		//Using set print the Environments variables
		Map<String, String> envMap = objPB.environment();
        Set<String> keys = envMap.keySet();
        for(String key:keys){
            System.out.println(key+" ==> "+envMap.get(key));
        }
	}
}
