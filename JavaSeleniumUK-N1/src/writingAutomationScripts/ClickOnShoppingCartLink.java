package writingAutomationScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import learningPOM.HomePage;
import learningPOM.LoginPage;
import learningPOM.WelcomePage;

public class ClickOnShoppingCartLink {
	@Test
	public void clickOnShoppingCartLink() {
		String loginPageLink = "https://demowebshop.tricentis.com/login";
		String userName = "komalgupta121@gmail.com";
		String password = "Shakuni123.@";
		String shoppingCartLink="https://demowebshop.tricentis.com/cart";
		
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
		Reporter.log("DemoWebShop is launched", true);
		SoftAssert softAssert = new SoftAssert();

		WelcomePage welcome = new WelcomePage(driver);
		// user clicked on login link
		welcome.getLoginLink().click();
		softAssert.assertEquals(driver.getCurrentUrl(), loginPageLink, "Login page is not displayed");
		Reporter.log("Login page is launched", true);

		LoginPage login = new LoginPage(driver);
		// user entered data into email text field
		login.getEmailTextField().sendKeys(userName);
		String actualUserName = login.getEmailTextField().getAttribute("value");
		softAssert.assertEquals(actualUserName, userName, "Username mismatched");
		Reporter.log("User entered correct email id into email text field", true);

		// user entered data into password text field
		login.getPasswordTextField().sendKeys(password);
		String actualPassword = login.getPasswordTextField().getAttribute("value");
		softAssert.assertEquals(actualPassword, password, "Password mismatched");
		Reporter.log("User entered correct password into password text field", true);

		// user clicked on login button
		login.getLoginButton().click();
		HomePage home = new HomePage(driver);
		boolean actualResult = home.getUserName().isDisplayed();
		softAssert.assertEquals(actualResult, true, "Login failed");
		Reporter.log("Login successful", true);
		
		//click on shopping cart link
		home.getShoppingCartLink().click();
		softAssert.assertEquals(driver.getCurrentUrl(), shoppingCartLink,"Shopping cart page is not opened");
		Reporter.log("Shopping cart page is opened",true);
	}
}
