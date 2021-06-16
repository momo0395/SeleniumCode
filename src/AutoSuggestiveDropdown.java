
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement autoDropdown=driver.findElement(By.id("autocomplete"));
		autoDropdown.sendKeys("Uni");
		List <WebElement> list=driver.findElements(By.xpath("//li[@class='ui-menu-item']")); 
		int rownum=driver.findElements(By.xpath("//li[@class='ui-menu-item']")).size();
		for(int i=0;i<rownum;i++) {
			if(list.get(i).getText().equals("United Arab Emirates")) {
				list.get(i).click();
			}
		}
	}

	
}
