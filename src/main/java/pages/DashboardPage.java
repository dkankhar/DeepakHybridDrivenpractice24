package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class DashboardPage extends ControlActions {
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement pageTitleVerification(String pageTitle) {
		String locator = String.format("//div[text()='%s']", pageTitle);
		return getElement("XPATH", locator, true);

	}
}
