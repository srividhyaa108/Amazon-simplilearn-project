package simplilearn.amazon;

import java.util.ArrayList;
import java.util.List;
import java.beans.Visibility;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageValidation {

	public String URL = "https://www.amazon.in/";
	WebDriver driver;
		@Before	
		public void login()
		{		
			
			System.setProperty("webdriver.gecko.driver", "/home/ubuntu/eclipse-workspace/Automate.Amazon/geckodriver");
			driver = new FirefoxDriver();
			driver.get(URL);
			}

	@Test
		public void validation()
		{
			WebDriverWait wait = new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-logo-link']")));
			
			//clicking on particular category
			driver.findElement(By.xpath("//*[@id='nav-xshop']/a[1]")).click();
			
			//fetching all options avaialable
			List<WebElement> ll1 = new ArrayList<WebElement> ();
			ll1 = driver.findElements(By.xpath("//span[@class='nav-a-content']"));
			
			for (WebElement webElement : ll1) {
				String name = webElement.getText();
				System.out.println(name);
				System.out.println("******************");
			}
			
		}
		
		@After
		public void end()
		{
			
		}
}
