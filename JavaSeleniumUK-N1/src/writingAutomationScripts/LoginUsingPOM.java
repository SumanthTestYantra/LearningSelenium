package writingAutomationScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import learningPOM.LoginPage;
import learningPOM.WelcomePage;

public class LoginUsingPOM {
	@Test
	public void login() {
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
		driver.get("https://demowebshop.tricentis.com/");

		WelcomePage welcome=new WelcomePage(driver);
		welcome.getLoginLink().click();
		
		LoginPage login=new LoginPage(driver);
		login.getEmailTextField().sendKeys("komalgupta121@gmail.com");
		login.getPasswordTextField().sendKeys("Shakuni123.@");
		login.getLoginButton().click();
	}
}
