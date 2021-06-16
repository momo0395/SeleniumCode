import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorID {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/test/facebook.html");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("adorablemau@yahoo.in");
		driver.findElement(By.id("pass")).sendKeys("krishnatulsi");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("email")).submit();
	}

}
