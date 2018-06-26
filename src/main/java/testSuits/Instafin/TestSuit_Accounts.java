package testSuits.Instafin;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Instafin.Page_DashBoard;
import pages.Instafin.Page_loginPage;
import pages.Instafin.Accounts.Page_Accounts_All_Accounts;
import pages.Instafin.Accounts.Page_Accounts_Loan_Accounts;
import utils.LoadPropertiesFile_Instafin;

public class TestSuit_Accounts {
	
	static LoadPropertiesFile_Instafin testData;
	
	WebDriver driver = new ChromeDriver();
	String baseurl = "https://meheditest.instafin.info/user/login";
	Page_loginPage login_PageElements = new Page_loginPage(driver);
	Page_DashBoard homePage_Elements = new Page_DashBoard(driver);
	Page_Accounts_All_Accounts accounts_All_Accounts_PageElements = new Page_Accounts_All_Accounts(driver);
	Page_Accounts_Loan_Accounts accounts_LoanAccounts_PageElements = new Page_Accounts_Loan_Accounts(driver);

	
	
	@BeforeTest
	public void beforeTesting() throws IOException {
		testData = new LoadPropertiesFile_Instafin();
		driver.manage().window().maximize();
		driver.get(testData.properties.getProperty("baseurl"));
		login_PageElements.inputUserName(testData.properties.getProperty("username"));
		login_PageElements.inputPassword(testData.properties.getProperty("password"));
		login_PageElements.clickOnLoginButton();
		homePage_Elements.verifyLogin();
	}
	
	//Area to write automated test cases using TestNG framework
	
	@Test
	public void Verify_Elements_Of_Accounts() {
		
	}
	
	
	
	
	@AfterTest
	public void afterTesting() throws InterruptedException {
		Thread.sleep(5000);
		login_PageElements.logoutFromApp();
		driver.close();
	}
}
