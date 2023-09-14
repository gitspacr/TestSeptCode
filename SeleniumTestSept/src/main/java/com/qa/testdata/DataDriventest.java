package com.qa.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDriventest {

	@DataProvider(name="passDataFromExcel")
	public String[][] excelTestData() throws Exception {
				
		File file =new File("./TestData/TestDataNew.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet =wb.getSheet("MyTestDataSheet");
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		System.out.println(sheet.getLastRowNum());
		int col =sheet.getRow(0).getLastCellNum();
		System.out.println(col);
		
		
		String[][] testData=new String[rows-1][col];
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<col;j++) {
				DataFormatter df=new DataFormatter();
				testData[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		
		wb.close();
		fis.close();
		return testData;
		
	}

}
