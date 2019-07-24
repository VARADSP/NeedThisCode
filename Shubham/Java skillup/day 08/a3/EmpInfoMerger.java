/**
 *
 */
package com.uks.jvs.day08.a3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: 	Shubham Bujurge
 * Created Date:16/05/2019 03: 15 PM
 * Assignment:  Day 8
 * Task:  Merging Employee Info
 *
 */
public class EmpInfoMerger {

	//initialization
	FileReader readfile = null;
	FileWriter writefile = null;
	BufferedReader buffer = null;

	public static String id = "";
	public static volatile String resource ="";

	//Constructor with passing file path and file mode
	EmpInfoMerger(String path, String mode) throws IOException, FileNotFoundException {
		if((mode.toLowerCase()).equals("read")){
			readfile = new FileReader(path);
			buffer = new BufferedReader(readfile);
		}
		else{
			writefile = new FileWriter(path);
		}
	}

	//For writing the into the resources
	void writeToResource() throws IOException, Exception{
		String line = buffer.readLine();

		while(line != null){
			if(!id.equals(Thread.currentThread().getName())){
				System.out.println(line);
				resource = resource + line + System.lineSeparator();
				id = Thread.currentThread().getName();
				Thread.sleep(10);
				line = buffer.readLine();
			}
			else{
				Thread.sleep(10);
			}
		}
	}

	//For writing into the file
	void writeToFile() throws IOException{
		writefile.write(resource);
		resource = null;
		writefile.close();
		System.out.println("Write Done");
	}
}
