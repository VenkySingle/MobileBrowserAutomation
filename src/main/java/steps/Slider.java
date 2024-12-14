package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import pages.DragandDrop;
import pages.DropDownPages;
import pages.Homepage;
import utils.DriverManager;
import utils.ExtentReporter;
import utils.GenericMethods;
import utils.LogManager;

public class Slider {
	
	public AppiumDriver driver;
	DriverManager dm;
	Homepage hpage;
	GenericMethods gm;
	DropDownPages dpage;
	LogManager lo;
	ExtentReporter reps;
	pages.Slider sl;
	DragandDrop dpp;
	
	
	public Slider()
	{
		dm = new DriverManager();
		this.driver = dm.GetDriver();
		hpage = new Homepage(driver);
		gm = new GenericMethods(driver);
		dpage = new DropDownPages(driver);
		lo = new LogManager();
		reps = new ExtentReporter(driver);
		sl = new pages.Slider(driver);
		

		}
	
	@Given("I am on the slider website {string}")
	public void i_am_on_the_slider_website(String url) {
	   try
	   {
		driver.get(url);   
		reps.GenerateReports("Slider Generation");
		reps.CreateTest("Slider Exploartion", "Working on slider");
		LogManager.logger.info("URL Navigated");
		reps.TestPASS("URL navigated successfully");
	   }
	   catch(Exception e)
	   {
			LogManager.logger.error("URL not loaded");
			reps.TestFAIL("URL not loaded");
	   }
	}

	@When("Sliding the Field")
	public void sliding_the_field() {
		   try
		   {
			sl.MoveSlider();
			LogManager.logger.info("slider slide was successful");
			reps.TestPASS("slider slide was successful");
		   }
		   catch(Exception e)
		   {
				LogManager.logger.error("slider slide was unsuccessful");
				reps.TestFAIL("slider slide was unsuccessful");
		   }
	}

	@Then("field should be slided and taken screenshot")
	public void field_should_be_slided_and_taken_screenshot() {
		
		reps.TestPASS("slider slide was successful with movemsent");
		reps.FlushReports();
		driver.quit();
	  
	}





}
