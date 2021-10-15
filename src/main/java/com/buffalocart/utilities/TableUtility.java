package com.buffalocart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class TableUtility {
	public static List<ArrayList<String>> gridData(List<WebElement> rowItems, List<WebElement> columnItems) {
		int rSize = rowItems.size();
	    int cSize = columnItems.size();
	    int clistSize = (columnItems.size() / rowItems.size() - 1)  ;

	    String[] columnList = new String[clistSize]; // 20/5 --->4
	    List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
	    int x = 0;
	    int s = columnList.length;
	    for (int i = 0; i < rowItems.size(); i++) {

	        for (int j = 0; j < columnList.length; j++) {

	            columnList[j] = columnItems.get(x).getText();

	             x++;
	        }
	        x++;
	        gridData.add(new ArrayList<String>(Arrays.asList(columnList)));

	    }
	    return gridData;
	}
	



public static List<ArrayList<WebElement>> actionData(List<WebElement> rowItems, List<WebElement> columnItems) {
	 int rSize= rowItems.size();
	    int cSize = columnItems.size();
	    int clistSize = (columnItems.size() / rowItems.size())  ;
	    WebElement[] columnList = new WebElement[clistSize]; 
	    List<ArrayList<WebElement>> gridData = new ArrayList<ArrayList<WebElement>>();
	    int x = 0;
	    int s = columnList.length;
	    for (int i = 0; i < rowItems.size(); i++) {

	        for (int j = 0; j < columnList.length; j++) {

	            columnList[j] = columnItems.get(x);

	            x++;
	        }
	        gridData.add(new ArrayList<WebElement>(Arrays.asList(columnList)));
	    }
	    return gridData;
}

	}

	// *[@id="users_table"]/tbody/tr[1]/td[1]
	// *[@id="users_table"]/tbody/tr[2]/td[1]
	// *[@id="users_table"]/tbody/tr[3]/td[1]

	// *[@id="users_table"]/tbody/tr[2]/td[2]

