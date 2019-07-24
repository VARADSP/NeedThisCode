/**
 *
 */
package com.jvs.uks.day05.a5;

import java.io.File;
import java.util.Scanner;

/**
 * @author: 	Shubham Bujurge
 * Created Date:10/05/2019 05: 43 PM
 * Assignment:  Day 5
 * Task:  File Filters & Directory Listing
 *
 */
public class DirectoryListing {
	private String[] okFileExtensions;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the path, extension and recursion");
			String name = scan.nextLine();
			DirectoryListing objDirectoryListing=new DirectoryListing();
			String ext=scan.nextLine();
			Boolean recur=scan.nextBoolean();
			objDirectoryListing.validate(name,ext,recur);
			scan.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public boolean accept(File path){
		for (String extension : okFileExtensions )
	    {
			if (path.getName().lastIndexOf(".") != -1 && path.getName().lastIndexOf(".") != 0)
			{
				return true;
			}

			else if (path.getName().toLowerCase().endsWith(extension))
			{
				return true;
			}
	    }
		return false;
	}

	// method to validate
	public void validate(String path,String exten, Boolean recursive){
		okFileExtensions=exten.split(",");
		try{
		File fileName= new File(path);

		System.out.println(fileName);
		if(fileName.isDirectory()){
			File[] files = fileName.listFiles();
			for (File f : files)
			{
				if(f.isFile()){
					if(accept(f)){
						System.out.println(f.getName());
				    }
				 }
				 else{
					 if(recursive){
				    	validate(f.toString(),exten,recursive);
					 }
				 }
			}
		}
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}

}
