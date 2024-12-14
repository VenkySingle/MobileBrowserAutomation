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

public class draganddropsteps {
	

	public AppiumDriver driver;
	DriverManager dm;
	Homepage hpage;
	GenericMethods gm;
	DropDownPages dpage;
	LogManager lo;
	ExtentReporter reps;
	pages.Slider sl;
	DragandDrop dpp;
	
	
	public draganddropsteps()
	{
		dm = new DriverManager();
		this.driver = dm.GetDriver();
		hpage = new Homepage(driver);
		gm = new GenericMethods(driver);
		dpage = new DropDownPages(driver);
		lo = new LogManager();
		reps = new ExtentReporter(driver);
		sl = new pages.Slider(driver);
		dpp = new DragandDrop(driver);

		}
	@Given("I am on the draganddrop website {string}")
	public void i_am_on_the_draganddrop_website(String url) {
		try
		{
		    driver.get(url);
		    LogManager.logger.info("URL Launched");
	        reps.GenerateReports("DragandDropInteractions");
	        reps.CreateTest("drag and drop selection", "Drag and drop");
	        reps.TestPASS("URL Launched Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			LogManager.logger.error("URL Failed..Thorws errior");
			reps.TestFAIL("URL Launched failed!!!");
		}
		
	 
	}

	@When("Dragging the pictures and drop to trash")
	public void dragging_the_pictures_and_drop_to_trash() {
		   try
		   {
			dpp.draganddrop();
			LogManager.logger.info("drag was successful");
			reps.TestPASS("drag was successful");
		   }
		   catch(Exception e)
		   {
				LogManager.logger.error("drag  was unsuccessful");
				reps.TestFAIL("drag was unsuccessful");
		   }

	}

	@Then("field should be dragged and taken screenshot")
	public void field_should_be_dragged_and_taken_screenshot() {
		reps.TestPASS("drap was successful with movemsent");
		reps.FlushReports();
		driver.quit();

	}


}
