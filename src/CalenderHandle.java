import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		//month picking
		WebElement month=driver.findElements(By.xpath("//*[@class='ui-datepicker-month']")).get(0);
		WebElement next=driver.findElements(By.xpath("//*[contains(text(),'Next')]")).get(1);
		for(int j=0;j<8;j++) {
			if(month.getText().contains("October")) 
				month.click();
				
		else 
				next.click();
			
		}
		
		//date picking
		List<WebElement> dateList=driver.findElements(By.className("ui-state-default"));
		for(int i=0;i<dateList.size();i++) {
			if(dateList.get(i).getText().equals("23")) {
				dateList.get(i).click();
				break;
			}
		}
		

	}

}
