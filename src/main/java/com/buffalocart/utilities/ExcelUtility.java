package com.buffalocart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static XSSFWorkbook workbook;
	static FileInputStream	f ;
	static XSSFSheet sheet;
	
	public ExcelUtility(String path,String sheetName) throws IOException
	{
		f = new FileInputStream(path);
		workbook=new XSSFWorkbook(f);
		sheet=workbook.getSheet(sheetName);
	}
	public  String getStringCellData(int rowNum,int columnNum) throws IOException
	{
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		String cellData=sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
		return cellData;
	}
	public double getNumericCellData(int rowNum,int columnNum) throws IOException
	{
		int rowCount=sheet.getPhysicalNumberOfRows();
		double cellData=sheet.getRow(rowNum).getCell(columnNum).getNumericCellValue();
		return cellData;
	}
	public List<String> getListCellData() throws IOException {
		int rowCount= sheet.getPhysicalNumberOfRows();
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i < rowCount; i++) {
			String cellValue = sheet.getRow(i).getCell(0).getStringCellValue();
			list.add(cellValue);
		}
		return list;
}
}
