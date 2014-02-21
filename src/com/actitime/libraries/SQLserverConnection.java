package com.actitime.libraries;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLserverConnection {
	 /**
	  * @param args
	  */
	  public SQLserverConnection() throws ClassNotFoundException, SQLException {
	   String query = "Select * FROM abc"; 
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=ARC;integratedSecurity=true;");
	         Statement stmt = connection.createStatement();
	     	//String sql1="insert into abc(name,sal) values('savitha',27)";
	         String sql1="delete from abc where name='savitha'";
    	   	stmt.executeUpdate(sql1);
	      ResultSet rs = stmt.executeQuery(query);
	       while(rs.next()){
	    	   	// String EmpNo=rs.getString("EmpId");
	    	   	//String empName=rs.getString("EmpName");
	    	   	String  EmpNo=rs.getString("name");
	    	   
	    	   	//String empName=rs.getString("EmpName");
	    	   	System.out.print(EmpNo+" ");
	    	   	//System.out.println(empName);
	    	   
	         }
	     }
	     public static void main(String[] args) throws ClassNotFoundException, SQLException {
	     new SQLserverConnection();
	     }
	  }
