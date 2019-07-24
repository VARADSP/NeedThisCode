/**
 *
 */
package com.jvs.uks.day07.a1;

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
 * Created Date:15/05/2019 10: 53 AM
 * Assignment:  Day 7
 * Task:  Searching the text in file
 *
 */
public class FindInFiles {

	//taking inputs from user
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the path : ");
		String path = scan.nextLine();
		System.out.println("Enter String : ");
		String string = scan.next();
		File file=new File(path);

		//Checking is file
		if(!file.isDirectory()){
			System.out.println("File name is: "+ file.getName());
			System.out.println("String name is: "+ string);
			matchString(file,string);
		}
		//Checking is directory and sub folder
		else{
			File[] fList = file.listFiles();
			//System.out.println("Directory name: "+ file.getName());
			System.out.println("Directory name: "+ path);
			System.out.println("String is : "+string);
			for(File filename: fList){
				if(filename.isFile())
					matchString(filename,string);	//call this function with parameter final name and string
			}
		}
		scan.close();
	}

	//maching the string with the file data and print line number
	private void matchString(File file, String string) {
		long count=file.length();
		String line="";
		int lineNum=1;
		try{
			@SuppressWarnings("resource")
			MappedByteBuffer out = new RandomAccessFile(file.getAbsolutePath(),"r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, count);	//checking the file path and readable file or not
			Pattern pattern = Pattern.compile(string);
			Matcher matcher;
			char alpha;

			for(int i = 0; i < count; i++){
				alpha = (char)out.get(i);
				if(alpha == '\n'){	//going to nextline
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
