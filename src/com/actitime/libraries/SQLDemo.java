package com.actitime.libraries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statement st=Generic.SQLStmt();
		//String sql= "delete from tblEmp where ENum=100";
		//st.executeUpdate(sql);
		
		String sql = "select * from tblEmp";
		ResultSet res = st.executeQuery(sql);
		while(res.next())
		{
			//res.moveToCurrentRow();
			System.out.print(res.getInt("ENum")+" ");
			System.out.print(res.getString("Ename"));
			System.out.println(res.getInt("salary"));
		}
		
		//update salary of pragna to 100000
		sql= "update tblemp set salary="+900000+" where ename like 'pragna%'";
		st.executeUpdate(sql);
		sql = "select * from tblEmp";
		 res = st.executeQuery(sql);
		while(res.next())
		{
			//res.moveToCurrentRow();
			System.out.print(res.getInt("ENum")+" ");
			System.out.print(res.getString("Ename")+" ");
			System.out.println(res.getInt("salary"));
		}
	}

}
