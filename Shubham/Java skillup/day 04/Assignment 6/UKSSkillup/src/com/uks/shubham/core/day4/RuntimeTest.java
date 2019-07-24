/**
 *
 */
package com.uks.shubham.core.day4;
import java.lang.ProcessBuilder;
import java.util.Map;
import java.util.Set;
/**
 * @author Shubham
 *
 */
public class RuntimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//creating a process Builder
		ProcessBuilder objPB = new ProcessBuilder();
		objPB.command("notepad.exe","the-file-name.txt");
		objPB.start();

		//Using set print the Environments variables
		Map<String, String> envMap = objPB.environment();
        Set<String> keys = envMap.keySet();
        for(String key:keys){
            System.out.println(key+" ==> "+envMap.get(key));
        }
	}
}
