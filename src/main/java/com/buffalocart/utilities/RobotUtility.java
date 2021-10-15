package com.buffalocart.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtility {
	public void robotclass() throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(2000);// thread.sleep();
		// setting the contents into the keyboard
		// ctrl+c--2 lines
		StringSelection stringselection = new StringSelection("D:\\SeleniumFiles\\ExtentReport");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.setAutoDelay(1000);
		// ctrl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
