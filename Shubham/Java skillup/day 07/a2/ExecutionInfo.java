/**
 *
 */
package com.jvs.uks.day07.a2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: 	Shubham Bujurge
 * Created Date:15/05/2019 02: 04 PM
 * Assignment:  Day 7
 * Task:  Garbage Collector
 *
 */
public class ExecutionInfo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime =System.nanoTime();
		//Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();

		System.out.println("Frre Memory after Garbeg Collector :" + runtime.freeMemory());	//after calling gc free memory
		runtime.gc();

		System.out.println("==================== Befor Start the Program Memory Stat ==================================");
									//Print used memory												//Print free memory
		System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) + "\nFree Memory:" + runtime.freeMemory());

		//calling Assignment 1 program
		ExecutionInfo objFindInFiles=new ExecutionInfo();
		objFindInFiles.input();

		System.out.println("==================== After End the Program Memory Stat ====================================");
											//Print used memory												//Print free memory
		System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) + "\nFree Memory:" + runtime.freeMemory());

		//calling garbage collector
		runtime.gc();
		System.out.println("Frre Memory after Garbeg Collector :" + runtime.freeMemory());	//after calling gc free memory

		//calculate time in nano sec
		long endTime = System.nanoTime();
		System.out.println("Time Required by System :"+ (endTime - startTime) + " nano sec");	//printing difference between end time & start time
	}

	//Taking input from user
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the path : ");
		String path = scan.nextLine();
		System.out.println("Enter String : ");
		String string = scan.next();
		File file=new File(path);

		if(!file.isDirectory()){
			System.out.println("File name is: "+ file.getName());
			System.out.println("String name is: "+ string);
			matchString(file,string);
		}
		else{
			File[] fList = file.listFiles();
			//System.out.println("Directory name: "+ file.getName());
			System.out.println("Directory name: "+ path);
			System.out.println("String is : "+string);
			for(File filename: fList){
				if(filename.isFile())
					matchString(filename,string);
			}
		}
		scan.close();
	}

	//Matching the string with file data and return the line number
	private void matchString(File file, String string) {
		long count=file.length();
		String line="";
		int lineNum=1;
		try{
			@SuppressWarnings("resource")
			MappedByteBuffer out = new RandomAccessFile(file.getAbsolutePath(),"r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, count);	//checking the file path and file is readable or not
			Pattern pattern = Pattern.compile(string);
			Matcher matcher;
			char alpha;

			for(int i = 0; i < count; i++){
				alpha = (char)out.get(i);
				if(alpha == '\n'){	//going to nect line
					matcher = pattern.matcher(line);
					if(matcher.find()){
						System.out.println("String is found in file: " + file.getName() + "Line Number is: "+ lineNum);	//string found then getting file name and line number
					}
					line = "";
					lineNum++;
				}
				else{
					line += alpha;
				}
			}
		}
		catch(FileNotFoundException e){
			System.err.println("file cant be opened");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
		}
	}
}
