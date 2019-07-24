/**
 *
 */


import java.sql.Connection;
import com.uks.shubham.day01.a3.PropertyUtil;

/**
* @author: 	Varad Paralikar
 * Created Date:07/06/2019 11: 30 AM
 * Assignment:  Day 2
 * Task:  	Displaying records in Per Page Fashion
 *
 */
public class DisplayUI {

	/**
	 * @param args
	 */
	//creating the connection object
	static Connection con = null;

	public static void main(String[] args) throws Exception {
		//calling Day1-a3 class for creating the connection
		PropertyUtil objPropertyUtil= new PropertyUtil();
		con = objPropertyUtil.connect();

		//Calling method of displayRowsPerPage
		DisplayUI.displayRowsPerPage();
		objPropertyUtil.disconnect();
	}

	public static void displayRowsPerPage() throws Exception{
		//Calling getRowsPerPage fetch Methods
		RowsFetcher objRowsFetcher = new RowsFetcher();
		//Assign Default size
		objRowsFetcher.rowsPerPage=5;
		//Pasing the Connection and Row per pgae
		objRowsFetcher.getRowsPerPage(con,7);

	}
}
