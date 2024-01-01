package testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ControlActions;
import pages.LoginPage;

public class TestBase {
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		ControlActions.launchBrowser();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
