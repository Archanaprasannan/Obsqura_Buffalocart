package com.buffalocart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TableUtility {
	public static List<String> excelTable() throws IOException {
		FileInputStream f = new FileInputStream(
				"D:\\Maven_Workspace\\ObsquraSelenium\\src\\main\\resources\\Company.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFRow row = sheet.getRow(0);
		int columnSize = row.getLastCellNum();
		int rowSize = sheet.getLastRowNum() + 1;
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				String cellvalue = sheet.getRow(i).getCell(j).getStringCellValue();
				if (cellvalue.equals("Island Trading")) {
					list.add(cellvalue);
				} else if (cellvalue.equals("Helen Bennett")) {
					list.add(cellvalue);
				} else if (cellvalue.equals("UK")) {
					list.add(cellvalue);
				}
			}
		}
		return list;
	}
}
