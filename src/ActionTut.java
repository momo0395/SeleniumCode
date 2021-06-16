import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionTut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		//moving to an element
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).build().perform();
		
		//Entering text search bar in caps
		WebElement textF= driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(textF).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();

		//right click on an element
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();
		
	}

}
