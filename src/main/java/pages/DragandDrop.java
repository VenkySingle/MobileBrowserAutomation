package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.GenericMethods;

public class DragandDrop {
	public AppiumDriver driver;
	GenericMethods method;
	public DragandDrop(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(30)),this);
		method = new GenericMethods(driver);
		
	}
	
	@FindBy(xpath = "//*[contains(text(),'High Tatras 3')]")
	WebElement source;
	
	@FindBy(xpath = "//div[contains(@id,'trash')]")
	WebElement target;
	
	//div[contains(@id,'trash')]
	
	public void draganddrop()
	{
		try
		{
		method.TouchActionwithDragandDrop(source,target);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
