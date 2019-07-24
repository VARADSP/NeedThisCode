/**
 *
 */
package com.jvs.uks.day06.a2;
/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 01: 30 PM
 * Assignment:  Day 6
 * Task:  Exception Handling
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Shubham
 *
 */
public class ExceptionDemo {

	void checkException() throws IOException{
		FileInputStream fis = null;
	    try
	    {
	      fis = new FileInputStream("D:\\test.txt");
	    }
	    catch(FileNotFoundException e)
	    {
	      System.out.println("The source file does not exist. " + e);	//Printing the FileNotFoundEXception
	    }
	    fis.close();	//Close the finle input stream for IOException
	    int k;
	    try
	    {
	      while(( k = fis.read() ) != -1)
	      {
	        System.out.print((char)k);
	      }
	      fis.close();
	    }
	    catch(IOException e)
	    {
	      System.out.println("Some IO problem. " + e);	//Printing the IOEXception
	      e.printStackTrace();	//Printing the stack trace
	    }
	}
}
