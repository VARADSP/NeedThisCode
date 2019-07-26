package com.uks.varad.jdbc.day01.JDBCTYPE1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBCType1Demo1
{
public Connection getConnection1()
{
  Connection con = null;
  try
  {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con = DriverManager.getConnection("jdbc:odbc:data1");
  }
  catch (Exception e)
  {
  System.out.println("Error in connection" + e);
  }
  return con;
}
public void getCustomer()
{
  try
  {
  Connection con = getConnection1();
  Statement st = con.createStatement();
  ResultSet res = st.executeQuery("select * from employees");
  while (res.next())
  {
    System.out.print(res.getString(1));
    System.out.print(res.getString(2));
    System.out.print(res.getString(3));
    System.out.println(res.getString(4));
  }
  res.close();
  con.close();
  }
  catch (Exception e)
  {
  System.out.println("Error in fetching data" + e);
  }
}
public static void main(String[] args)
{
  new JDBCType1Demo1().getCustomer();
}
}