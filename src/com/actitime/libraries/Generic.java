package com.actitime.libraries;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Generic
{
	public static int XLRow(String xlname,String sheet)
	{
		int rc;
		try{
		FileInputStream fis = new FileInputStream(xlname);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet st=wb.getSheet(sheet);
		 rc=st.getLastRowNum();
		}
		catch(Exception e)
		{
			return rc=-1;
		}
		return rc;
	}
	
	public static int XLColumn(String xlname,String sheet,int row)
	{
		int cc;
		try{
		FileInputStream fis = new FileInputStream(xlname);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet st=wb.getSheet(sheet);
		cc=wb.getSheet(sheet).getRow(row).getLastCellNum();
		}
		catch(Exception e)
		{
			return cc=-1;
		}
		return cc;
	}


public static String XLCellValue(String xlname,String sheet,int rowNum,int cellNum)
{
	String cellValue;
	try{
	FileInputStream fis = new FileInputStream(xlname);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet st=wb.getSheet(sheet);
	cellValue=wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	catch(Exception e)
	{
		return cellValue=" ";
	}
	return cellValue;
}
// integer cell value
public static double XLIntCellValue(String xlname,String sheet,int rowNum,int cellNum)
{
	double cellValue;
	try{
	FileInputStream fis = new FileInputStream(xlname);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet st=wb.getSheet(sheet);
	cellValue=wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	catch(Exception e)
	{
		return cellValue=0.0;
	}
	return cellValue;
}

//Sql server connection
public static Statement SQLStmt() throws ClassNotFoundException, SQLException
{
	
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Prateeksh;integratedSecurity=true;");
    Statement stmt = connection.createStatement();
    return stmt;
}
}
