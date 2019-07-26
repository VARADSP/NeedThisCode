package com.uks.varad.jdbc.day02.assignment1_trial;

/**
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.uks.varad.jdbc.day01.assignment3.PropertyUtil;

/**
* @author: 	Varad Paralikar
 * Created Date:24/07/2019
 * Assignment:  Day 2
 * Task: 	Displaying records in Per Page Fashion
 *
 */
public class RowsFetcher {

	//intializing the variables
	int rowsPerPage=5;
	Connection con=null;

	RowsFetcher(){
		Connection connection;
		try {
			//creating object of PropertyUtil class
			new PropertyUtil();
			//searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			//connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl,PropertyUtil.databaseUsername,PropertyUtil.databasePassword);
			this.con = connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	EmpData emp = new EmpData();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	List<EmpData> list = new ArrayList();

	//This method give the result in form of list
	public List<EmpData> getRowsPerPage(Connection con,int rowCount) throws Exception{

		Connection connection = null;
		try {
			//creating object of PropertyUtil class
			new PropertyUtil();
			//searching for mysql driver class
			Class.forName(PropertyUtil.databaseDriverClass);
			System.out.println("Database Connecting...");
			System.out.println("......................");
			//connecting to the database
			connection = DriverManager.getConnection(PropertyUtil.databaseUrl,PropertyUtil.databaseUsername,PropertyUtil.databasePassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		this.con = connection;
		Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//fire query and store result in resultSet
		ResultSet rs = st.executeQuery("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
		//for formatting of the Headers
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");

		//Checking row per page
		if(rowCount < 1)
			rowCount = this.rowsPerPage;

		int page = 1;
		int row =rowCount;

		//is executed until no more rows is there
		while(rs.next()){
			//Printing the Result in tabular format
			System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			row--;
			if(row == 0)
				break;
		}

		//Getting values from user
		Scanner scan = new Scanner(System.in);
		char ch;
		do{
			System.out.println("Enter N for NextPage or P for PreviousPage");
			ch = scan.next().charAt(0);
			//For next page
			if(ch == 'N'){
				page++;
				int rowsInfo = ((page * rowCount) - rowCount+1);
				rs.absolute(rowsInfo);
				System.out.println("Page No,"+ page);
				int index = rs.getRow();
				//if index is greater than 1 then only next records should be display
				if(index > 1)
					//calling rowsPerPage method is called and pasing con,rowCount, newx/Prev and current index
					getRowsPerPage(con,rowCount,'N',index);
				else{
					System.out.println("No More Records is there");
					break;
				}
			}
			//For previous page
			else if(ch == 'P'){
				page--;
				if(page<1){
					page = 1;
				}
				int rowsInfo = ((page * rowCount) - rowCount+1);
				rs.absolute(rowsInfo);
				System.out.println("Page No,"+ page);
				int index = rs.getRow();
				//if index is greater than 1 then only previous records should be display
				if(index >=1)
					//calling rowsPerPage method is called and pasing con,rowCount, newx/Prev and current index
					getRowsPerPage(con,rowCount,'P',index);
			}
		}while(!(ch == 'X'));
		//If enter X then program stops

		scan.close();
		//Returning the list
		return list;
	}


	public List<EmpData> getRowsPerPage(Connection con,int rowsPerPage, char choice, int index) throws Exception{

		Statement st = this.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//fire query and store result in resultSet
		ResultSet rs = st.executeQuery("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
		//for formatting of the Headers
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");

		//For next page
		if(choice== 'N' || choice== 'n'){
			//Checking index location
			if(index<=1){
				index=2;
			}
			else{
				rs.absolute(index-1);
			}
			if(rs.isLast()){
				index=1;
				rs.absolute(index);
			}
		}
		//For previous page
		else if(choice == 'P' || choice== 'p'){
			//Checking index location
			if(index <= 1){
				index =0;
			}
			else{
				rs.absolute(index-1);
			}
		}

		int row = rowsPerPage;
		//rs.absolute(row);
		while(rs.next()){
			//Printing the Records
			System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			row--;
			//if row count is then break the program execution
			if(row==0){
				break;
			}
		}
		System.out.println("==============================================================================================================================================================");
		//Returning the list
		return list;
	}
}
