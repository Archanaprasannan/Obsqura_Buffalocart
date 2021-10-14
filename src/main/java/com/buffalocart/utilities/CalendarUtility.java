package com.buffalocart.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarUtility {
public static String getCurrentDate()
{
	DateFormat formatdate=new SimpleDateFormat("MM/dd/yyyy");
	Date date=new Date();
	String datevalue=formatdate.format(date);
	return datevalue;
}
}
