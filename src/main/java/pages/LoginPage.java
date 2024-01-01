package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class LoginPage extends ControlActions {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "txtUsername")
	WebElement uNameTextBoxElement;
	
	@FindBy(name="txtPassword")
	WebElement passwordTextBoxElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButtonElement;
		
	public void enterUname() {
		String uName = propOperation.getValue("uname");
		populateText(uNameTextBoxElement, uName);
		//uNameTextBoxElement.sendKeys(uName);
	}
	
	public void enterPassword() {
		String uPassword = propOperation.getValue("password");
		populateText(passwordTextBoxElement, uPassword);
	}
	
	public void clickLogin() {
		clickElement(loginButtonElement);
	}
}
