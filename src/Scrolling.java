
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,500)");
		//getting sum of amount column values
		
		int rownum=driver.findElements(By.xpath("//div[@class='tableFixHead'] //table[@id='product' ]//tbody//tr")).size();
		
		int sum=0;
		for(int i=1;i<=rownum;i++) {
			
			sum=sum+Integer.parseInt(driver.findElement(By.xpath("//div[@class='tableFixHead'] //table[@id='product' ]//tbody//tr["+i+"]//td[4]")).getText());
		
		}
		
		System.out.println(sum);
		WebElement totalAmountString=driver.findElement(By.cssSelector(".totalAmount"));
		String str[]=totalAmountString.getText().split(":");
		int total=Integer.parseInt(str[1].trim());
		System.out.println(total);
		
		
	}

}
