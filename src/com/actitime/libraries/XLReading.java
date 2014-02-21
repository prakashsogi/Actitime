package com.actitime.libraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLReading {

	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		FileInputStream f1=new FileInputStream("G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx");
		Workbook wb= WorkbookFactory.create(f1);
		Sheet st= wb.getSheet("multitask");
		int rc= st.getLastRowNum();
		for(int i=0;i<=rc;i++)
		{
			Row r=st.getRow(i);
			int cc= r.getLastCellNum();
			for(int j=0;j<cc;j++)
			{
				System.out.print(r.getCell(j).getStringCellValue()+"|");
			}
			System.out.println();
		}
		

	}

	
}
