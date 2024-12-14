package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.GenericMethods;

public class DropDownPages {
	
	public AppiumDriver driver;
	GenericMethods method;
	public DropDownPages(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(30)),this);
		method = new GenericMethods(driver);
		
	}
	
	@FindBy(xpath = "//select[@id = 'oldSelectMenu']")
	WebElement OldSelectMenu;
	
	@FindBy(xpath = "//div[contains(@id,'withOptGroup')]")
	WebElement GrpSelectMenu;
	
	@FindBy(xpath = "//*[contains(text(),'Group 2, option 1')]")
	WebElement ValueSelectForGroup;
	
	
	
	
	
	public void SelectDropdown(String value)
	{
		method.SelectDropdownwithText(OldSelectMenu, value);
		method.TakeScreenshot("dropdownselected to blue");
	}
	
	public void clickandSelectGroupMenu()
	{
	method.DoClickWithLoop(GrpSelectMenu);
	method.TakeScreenshot("dropdown clicked");
	method.DoClickWithLoop(ValueSelectForGroup);
	method.TakeScreenshot("dropdown value selected");
	
	}

	public void AssertDropDown(String Data)
	{
		  Select select = new Select(OldSelectMenu);
		  String selectedValue = select.getFirstSelectedOption().getText();
		  SoftAssert asserts = new SoftAssert();
		  asserts.assertEquals(selectedValue, Data);
	}
}
