package writingAutomationScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_Homepage_003 {

	@Test
	public void toClickRegisterButton(){
		
		String registerUrl="https://demowebshop.tricentis.com/";
		String firstName="Praneetha";
		String lastName="Singh";
		String email="procky@gmail.com";
		String password="prannu123.@";
		String message="Your registration completed";
		// to set and path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// to launch empty browser--Upcasting
		WebDriver driver = new ChromeDriver();
		Reporter.log("Browser is launched",true);
		// maximize the browser
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized",true);
		// adding implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// launching the web site
		driver.get("https://demowebshop.tricentis.com/");
		Reporter.log("URL is launched",true);
		SoftAssert softAssert=new SoftAssert();

		//CLICKING ON REGISTER LINK
		driver.findElement(By.linkText("Register")).click();
		softAssert.assertEquals(driver.getCurrentUrl(), registerUrl,"Register page is not launched");
		Reporter.log("Registration page is launched",true);
		
		//CLICKING ON GENDER RADIO BUTTON
		WebElement maleRadioButton = driver.findElement(By.id("gender-male"));
		maleRadioButton.click();
		softAssert.assertEquals(maleRadioButton.isSelected(),true,"Male raio button is not selected");
		Reporter.log("User selected male radio button",true);
		
		
		WebElement firstNameTextField = driver.findElement(By.id("FirstName"));
		firstNameTextField.sendKeys(firstName);
		softAssert.assertEquals(firstNameTextField.getAttribute("value"),firstName,"First name is not matching");
		Reporter.log("User entered correct first name in first name text field",true);
		
		WebElement lastNameTextField = driver.findElement(By.id("LastName"));
		lastNameTextField.sendKeys(lastName);
		softAssert.assertEquals(lastNameTextField.getAttribute("value"), lastName, "Last name is not equal");
		Reporter.log("User entered correct last name in last name text field",true);
		
		WebElement emailTextField = driver.findElement(By.id("Email"));
		emailTextField.sendKeys(email);
		softAssert.assertEquals(emailTextField.getAttribute("value"),email,"Email mismatch");
		Reporter.log("User entered correct email in email text field",true);
		
		WebElement passwordTextField = driver.findElement(By.id("Password"));
		passwordTextField.sendKeys(password);
		softAssert.assertEquals(passwordTextField.getAttribute("value"), password,"Password mismatch");
		Reporter.log("User entered correct password in password text field",true);
		
		WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
		confirmPassword.sendKeys(password);
		softAssert.assertEquals(confirmPassword.getAttribute("value"),password,"Confirmed password is not matching");
		Reporter.log("User confirmed the password",true);
		
		driver.findElement(By.id("register-button")).click();
		WebElement confirmationText = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
		String confirmMessage=confirmationText.getText();
		softAssert.assertEquals(confirmMessage,message,"Registration is not successfull");
		Reporter.log("User registered successfully",true);
		
		softAssert.assertAll();
		driver.quit();
	}
}
