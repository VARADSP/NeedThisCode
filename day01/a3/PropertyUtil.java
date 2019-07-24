/**
 *
 */


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;



/**
 * @author: 	Varad Paralikar
 * Created Date:06/06/2019 11: 31 AM
 * Assignment:  Day 1
 * Task: 		Connection from properties file
 *
 */
public class PropertyUtil {

	//initializing the object of connection
	 Connection con = null;

	//For creating the connection
	public Connection connect(){
		try{
			//Passing the property file location
			/*FileInputStream fis=new FileInputStream("D:\\JVS_WS\\JDBC\\src\\com\\uks\\shubham\\day01\\a3\\settings.properties");
			Properties prop=new Properties ();
			prop.load(fis);*/
			FileInputStream fis=new FileInputStream("D:\\JVS_WS\\JDBC\\src\\com\\uks\\shubham\\day01\\a3\\settings.properties");
			ResourceBundle myBundle = new PropertyResourceBundle(fis);
			String dbname = myBundle.getString("DBname");
			String url = myBundle.getString("URL");
			String uname = myBundle.getString("Username");
			String pass = myBundle.getString("Password");


			//Getting values from properties file
			/*String dbname = (String) prop.get("DBname");
			String url = (String) prop.get("URL");
			String uname = (String) prop.get("Username");
			String pass = (String) prop.get("Password");*/

			//finding the class
			Class.forName(dbname);
			//establishmenting the connection
			con = DriverManager.getConnection(url,uname,pass);
			System.out.println("Database Connecting.....");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

	//For Display the details of the employee class
	public void displayRecords(){
		try {
			Statement stmt = con.createStatement();
			//fire query and store result in resultSet
			ResultSet rs = stmt.executeQuery("SELECT EmployeeID, concat(FirstName,' ', LastName) as FullName,Title,concat(Address ,city ,country) as Address,HomePhone FROM employees");
			//for formatting of the Headers
			System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
			System.out.println("==============================================================================================================================================================");
			//is executed until no more rows is there
			while(rs.next()){
				//Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			System.out.println("==============================================================================================================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//For closing the conncetion
	public void disconnect() throws Exception{
		System.out.println("Database Disconnecting.....");
		con.close();
		//closing the connection
	}
}
