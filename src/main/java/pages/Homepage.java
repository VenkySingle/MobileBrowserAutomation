package pages;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.GenericMethods;

public class Homepage {
	
	public AppiumDriver driver;
	GenericMethods method;
	public Homepage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(30)),this);
		method = new GenericMethods(driver);
		
	}
	
	@FindBy(xpath = "//h5[contains(text(),'Elements')]")
	WebElement MainMenu;
	
	@FindBy(xpath = "(//*[contains(text(),'Widgets')])//following::div[1]")
	WebElement WidgetMenu;
	
	@FindBy(xpath = "//*[contains(text(),'Select M')]")
	WebElement SelectMenu;
	
	
	
	
	
	public void NavigatetoDropdownpage()
	{
		
		
		method.DoClickWithLoop(MainMenu);
		method.TakeScreenshot("MainMenuNavigated");
		
		method.DoClickWithLoop(WidgetMenu);
		method.TakeScreenshot("WidgetMenuNavigated");

		method.DoClickWithLoop(SelectMenu);
		method.TakeScreenshot("SelectMenuNavigated");
	}
	

}
