package learningPOM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LearningStaleElementException {
	@Test
	public void checkLoginButton() throws InterruptedException {
		// to set and path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// to launch empty browser--Upcasting
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser is launched", true);
		// maximize the browser
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized", true);
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// launching the web site
		driver.get("https://www.instagram.com/");
		
		WebElement loginButton = driver.findElement(By.xpath("//div[text()='Log in']"));
		System.out.println(loginButton.isEnabled());
		driver.navigate().refresh();
		driver.findElement(By.name("username")).sendKeys("Sumanth");
		driver.findElement(By.name("password")).sendKeys("123456789");
		System.out.println(loginButton.isEnabled());
//		System.out.println(driver.findElement(By.xpath("//div[text()='Log in']")).isEnabled());
		
	}
}
