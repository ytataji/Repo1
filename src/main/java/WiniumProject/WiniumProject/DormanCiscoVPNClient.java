package WiniumProject.WiniumProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class DormanCiscoVPNClient {
	public static WiniumDriver driver;
	Robot robot;
	static String windowHandle;
	
	static String _vpnclientpath;

	

	public static  void SetupWinium() {

		DesktopOptions options = new DesktopOptions();
		 _vpnclientpath = "C:\\Users\\tyerubandhi\\Downloads\\text.txt";
		options.setApplicationPath(_vpnclientpath);
		try {

			File drivePath = new File(
					"C:\\Users\\tyerubandhi\\Desktop\\eclipse\\WiniumProject\\Winium.Desktop.Driver.exe");

			WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath)
					.usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();

			service.start();
			driver = new WiniumDriver(service, options);
			windowHandle = driver.getWindowHandle();

			Thread.sleep(5000);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ConnectToCalculator() throws InterruptedException {

		SetupWinium();

		/*
		 * if (driver.findElement(By.id("1404")) != null)
		 * driver.findElement(By.id("1404")).click(); else {
		 * driver.switchTo().window(windowHandle);
		 * driver.findElement(By.id("1404")).click(); }
		 */
		Runtime rt = Runtime.getRuntime();
		/*try {
			rt.exec(_vpnclientpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		driver.findElement(By.className("Edit")).sendKeys("This is my first winium test");
		
		Actions a=new Actions(driver);
		Thread.sleep(3000);
		WebElement e1=driver.findElement(By.id("Item 1"));
		
		WebElement e2=driver.findElement(By.id("Item 4"));
		
		a.moveToElement(e1).build().perform();
		a.moveToElement(e2).click().build().perform();
		
		


		
		
	}

	public static void WaitForTheWindow(String _window_name) {
		int _iterate = 30;
		while (driver.findElement(By.name(_window_name)) == null && _iterate < 20) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_iterate++;
		}
	}

	public void SendKeyStorkes(String _char_sequence) {
		char[] _char_arr = _char_sequence.toCharArray();
		for (char c : _char_arr) {
			driver.getKeyboard().sendKeys(String.valueOf(c));
		}
	}

	public void PerformKeyPress(int _key_code) {
		robot.keyPress(_key_code);
		robot.keyRelease(_key_code);
	}

	public void PerformModifierKeyPress(int[] _key_code) {
		for (int i : _key_code) {
			robot.keyPress(i);
		}
		for (int i : _key_code) {
			robot.keyRelease(i);
		}
	}

	public static void CloseWinium() {
		driver.close();
		driver.quit();
	}
	
	
	public static void main(String[]args) throws InterruptedException {
		
		
		
		ConnectToCalculator();
		CloseWinium();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
