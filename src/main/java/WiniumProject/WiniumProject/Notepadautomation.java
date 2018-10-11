package WiniumProject.WiniumProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class Notepadautomation {
	public static WiniumDriver driver;
	Robot robot;
	static String windowHandle;

	
	public static void main(String[]args) {
	
		DesktopOptions options = new DesktopOptions();
		//String _vpnclientpath = System.getenv("ProgramFiles") + " (x86)\\"
				//+ "\\Cisco\\Cisco AnyConnect Secure Mobility Client\\vpnui.exe";
		//options.setApplicationPath(_vpnclientpath);
		try {

			File drivePath = new File(
					"C:\\Users\\tyerubandhi\\Desktop\\eclipse\\WiniumProject\\Winium.Desktop.Driver.exe");
		
			WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath)
					.usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
			//System.out.println("tataji");
			service.start();
			driver = new WiniumDriver(service, options);
			windowHandle = driver.getWindowHandle();

			Thread.sleep(5000);

		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	

		/*
		 * if (driver.findElement(By.id("1404")) != null)
		 * driver.findElement(By.id("1404")).click(); else {
		 * driver.switchTo().window(windowHandle);
		 * driver.findElement(By.id("1404")).click(); }
		 */
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("C:\\Users\\tyerubandhi\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories\\Notepad.exe");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		

	}
	



	
}
