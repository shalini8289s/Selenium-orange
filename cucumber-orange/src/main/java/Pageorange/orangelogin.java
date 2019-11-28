package Pageorange;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.OrangeTestBase;

public class orangelogin extends OrangeTestBase {

	//Page Factory - OR:
	@FindBy(id="txtUsername")
	WebElement LoginUserID;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	
	@FindBy(id="divLoginButton")
	WebElement LoginSubmitButton;
	
	
	//initializing pagefactory
	public orangelogin(){
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Actions
	
	public orangeHomepage login(String Username,String paswword){
		LoginUserID.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		LoginSubmitButton.click();
		return new orangeHomepage();
	}
	
	
	public String homepagetitle(){
		return driver.getTitle();
		
	}
	

}
