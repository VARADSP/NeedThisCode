package com.uks.varad.jdbc.day02.assignment2_trial;

/**
 *
 */


import java.util.List;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
* @author: 	Varad Paralikar
 * Created Date:24/07/2019
 * Assignment:  Day 2
 * Task:  	Getting records from Stored Procedure
 *
 */
public class SalesByCategoryRunner {

	//Default input assign
	int rowsPerPgae = 5;
	Connection con = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	//Intialize the list
	List<SalesByCatData> list = new ArrayList();
	/**
	 * fetch records from SalesByCatData and store in list
	 * @param name
	 * @param year
	 * @return
	 * @throws SQLException
	 */

	//Constructor with parameters
	SalesByCategoryRunner(Connection con,int rowsPerPage){
		this.con = con;
		this.rowsPerPgae = rowsPerPage;
	}

	//Display the list of resulset and returning the list
	public List<SalesByCatData> fetchRecords(String name,String year) throws SQLException{
		//Calling procedure
		 String query = "{ call SalesByCategory(?,?) }";
		CallableStatement callStmt = con.prepareCall(query);
		//Passing parameteres to procedure
		callStmt.setString(1, name);
		callStmt.setString(2, year);
		callStmt.execute();
		ResultSet rs=callStmt.getResultSet();

		//Default header is printing
		System.out.printf("%-50s %40s \n", "Product Name","Total Purchase");
		System.out.println("===================================================================");

		//adding all the data to the list
		while(rs.next()){
			list.add(new SalesByCatData(rs.getString(1),rs.getDouble(2)));
		}

		//Intialize the intial variables
		int rows = rowsPerPgae;
		char choice ;
		int page =1,lastPage;
		//Calculating the last page size
		lastPage = (list.size()/rows)+1;

		Scanner sc = new Scanner(System.in);
		SalesByCatData objSalesByCatData = null;

		//Executing loop
		do{
			//checking the last page
			if(page < 1){
				System.out.println("You are in last page");
				page = 1;
			}
			//if page is not last page then execute this
			else{
				int rowpos = ((page* rows) - rows);
				for(int i = rowpos; i < rowpos + rowsPerPgae; i++){
					//If page is last page then print the message
					if(i >= list.size()){
						break;
					}
					//List data will be printed
					objSalesByCatData = list.get(i);
					System.out.printf("%-50s %40s \n",objSalesByCatData.productName,objSalesByCatData.totalPurches);
				}
				//if pag is last page then display message
				if(page == lastPage){
					System.out.println("====================");
					System.out.println("You are in last page");
					page = lastPage;
					break;
				}
			}
			System.out.println("===================================================================");
			//Getting values from user
			System.out.println("Enter N for next ,P for previous and X for Exit");
			choice=sc.next().charAt(0);

			//For next page
			if(choice == 'N' || choice =='n'){
				page++;
			}
			//For Previous page
			else if(choice == 'P' || choice =='p'){
				page--;
			}
			//for closing the program
			else if(choice == 'X' || choice =='x'){
				break;
			}
			//entered invalid input
			else{
				System.out.println("Enter a valid input");
			}
		}while(choice != 'X');
		//checks the enter value is x until execution is continue
		//closing the scanner object
		sc.close();
		//returing the list
		return list;
	}
}
