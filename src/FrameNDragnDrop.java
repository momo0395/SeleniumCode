import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameNDragnDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		//switching to frame
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		//dragging and dropping elements within the frame 
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("draggable"))).clickAndHold().moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		//Switching back to main window
		driver.switchTo().defaultContent();
		

	}
	

}
