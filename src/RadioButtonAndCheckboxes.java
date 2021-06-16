import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonAndCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/radio.html");
		driver.findElement(By.id("vfb-7-1")).click(); // same goes for check boxes
		driver.findElement(By.id("vfb-7-2")).click();
		System.out.println(driver.findElement(By.id("vfb-7-1")).isSelected());
		driver.close();	
		
	}

}
