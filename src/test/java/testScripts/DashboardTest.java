package testScripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardTest extends TestBase {

	public void PageTitleCheck(String pageTitleExpected) {
		WebElement element = dashboardPage.pageTitleVerification(pageTitleExpected);
		Assert.assertTrue(element.getText().equals(pageTitleExpected), "Page Title is not as expected");
	}
}	
