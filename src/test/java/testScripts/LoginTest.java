package testScripts;

import org.testng.annotations.Test;
	
public class LoginTest extends TestBase{
	
	@Test
	public void Login() {
		loginPage.enterUname();
		loginPage.enterPassword();
		loginPage.clickLogin();
		dashboardPage.pageTitleVerification("Employee Management");
	}
}
