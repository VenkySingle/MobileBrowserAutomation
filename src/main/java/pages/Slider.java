package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.GenericMethods;

public class Slider {
	
	public AppiumDriver driver;
	GenericMethods method;
	public Slider(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(30)),this);
		method = new GenericMethods(driver);
		
	}
	
	@FindBy(xpath = "//div[@id= 'slider']")
	WebElement Slider;
	
	public void MoveSlider()
	{
		try
		{
		method.MoveSlider(Slider);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
