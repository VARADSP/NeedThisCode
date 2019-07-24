/**
 *
 */
package com.jvs.uks.day04;

import java.io.File;
import java.util.Scanner;

/**
  * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 2: 47 PM
 * Assignment:  Day 4
 * Task: File Info
 *
 */
public class FileInfo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Directory of file");
		String filePath = sc.nextLine();

		//creating the object of file
		FileInfo objFile = new FileInfo();
		objFile.printInfo(filePath);
		sc.close();
	}
	void printInfo(String strFilePath){	//for calculating all size directory and dictionary
		try{
			File file=new File(strFilePath);
			if(file.isFile()){
				System.out.println(strFilePath+" is file of size : "+file.length()/1024);
			}
			else if(file.isDirectory()){
				System.out.println(strFilePath+" is directory size ;"+ (this.fileSize(file)/1024));
			}
			else
			{
				System.out.println("Invalid Directory");
			}
			}
			catch(Exception e)
			{
				System.out.println("Invalid path");
			}
	}

	//Calculating the size of the folder
	private long fileSize(File file) {
		long size=0;
		File[] files=file.listFiles();
		if(files == null || files.length == 0){
			return size;
		}
		for(File f:files){
			if(f.isFile()){
				size+=f.length();
			}
			else{
				size+=fileSize(f);
			}
		}
		return size;
	}
}
