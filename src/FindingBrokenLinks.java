import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingBrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\su\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String HomePage="https://www.zlti.com/";
		String url;
		driver.get(HomePage);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> it=links.iterator();
		while(it.hasNext()) {
			
			url=it.next().getAttribute("href");
			if(!url.startsWith(HomePage)) {
				System.out.println(url+" This url points to link outside of this web application");
				continue;
			}
			if(url==null||url=="") {
				System.out.println(url+" This url is empty or NULL");
				continue;
			}
			try {
				HttpURLConnection conn=(HttpURLConnection)(new URL(url).openConnection());
				conn.setRequestMethod("HEAD");
				conn.connect();
				int respCode=conn.getResponseCode();
				if(respCode<400) {
					System.out.println(url+" This URL is working and not broken");
				}
				else {
					System.out.println(url+" This URL is broken");
				}
			} catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
