package utils;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class GenericMethods {
	
	public Actions action;
	ExtentReporter reporter;
	public TouchAction taction;
	public AppiumDriver driver;
	
	public GenericMethods(AppiumDriver driver)
	{
		this.driver = driver;
		reporter = new ExtentReporter(this.driver);
	}
	
	public void DoClick(WebElement element)
	{
		try
		{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOf(element));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", element);
	element.click();	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	public void fillField(WebElement element,String value)
	{
		try
		{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);	
		}
		catch(Exception e)
		{
			if (element.getText().equals("null"))
				{
			element.sendKeys(value);
				}
			e.printStackTrace();
		}
	}
	public void SelectDropdownwithText(WebElement element,String value)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.elementToBeSelected(element));
           Select select = new Select(element);
           select.selectByVisibleText(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static double generateRandomNumber()
	{
		double number = Math.random();
		number = number * 999999;
		return  number;
		
	}
	
	public File TakeScreenshot(String filename)
	{
		try
		{
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\"+filename+generateRandomNumber()+ ".png");
		FileUtils.copyFile(source,target);
		return target;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void DoClickWithLoop(WebElement element)
	{
		try
		{
	boolean IsClicked = false;
	int RetryTimes = 3;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOf(element));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	for(int i=1;i<=RetryTimes;i++)
	{
		try {
			if(IsClicked == false)
			element.click();
			IsClicked = true;
		}
		catch(Exception e)
		{
			IsClicked = false;
			Thread.sleep(2000);
			
		}
		
	}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	
	public void MoveSlider(WebElement slider)
	{
		try
		{
			
		int initialX = slider.getLocation().getX();
		int initialY = slider.getLocation().getY();
		 int width = slider.getSize().getWidth();
		 int positiontomove = initialX + (width/2);
		 LogManager.logger.info("Initial X"+initialX);
		 LogManager.logger.info("Initial Y"+initialY);
		 LogManager.logger.info("Width"+width);

		 
		 action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(slider));
		 LogManager.logger.info("Move to position is"+ (positiontomove - initialX));
		 action.moveToElement(slider,positiontomove - initialX,0).
		 click().build().perform();
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

		
	}
	
	public void TouchActionwithDragandDrop(WebElement Source, WebElement target)
	{
		
		try
		{
			int sourceInitialPosition = Source.getLocation().getX();
			int sourceFinalPosition = Source.getLocation().getY();
			int targetInitialPosition = Source.getLocation().getX();
			int targetFinalPosition = Source.getLocation().getY();
			taction = new TouchAction((PerformsTouchActions) driver);
			taction.press(PointOption.point(sourceInitialPosition, sourceFinalPosition)).
			waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).
			moveTo(PointOption.point(targetInitialPosition,targetFinalPosition)).release().perform();
			LogManager.logger.info("Draagged and dropped");
		}
		catch(Exception e)
		{
			LogManager.logger.error("Draagged and dropped");
			e.printStackTrace();
		}
	}
	

}
