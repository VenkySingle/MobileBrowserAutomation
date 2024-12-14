package steps;


import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import pages.DropDownPages;
import pages.Homepage;
import utils.DriverManager;
import utils.ExtentReporter;
import utils.GenericMethods;
import utils.LogManager;

public class DropDownInteractions {
	public AppiumDriver driver;
	DriverManager dm;
	Homepage hpage;
	GenericMethods gm;
	DropDownPages dpage;
	LogManager lo;
	ExtentReporter reps;
	
	public DropDownInteractions()
	{
		dm = new DriverManager();
		this.driver = dm.GetDriver();
		hpage = new Homepage(driver);
		gm = new GenericMethods(driver);
		dpage = new DropDownPages(driver);
		lo = new LogManager();
		reps = new ExtentReporter(driver);
		
		
	}

	@Given("I am on the website {string}")
	public void i_am_on_the_website(String url) {
		try
		{
	    driver.get(url);
	    LogManager.logger.info("URL Launched");
        reps.GenerateReports("DropDownInteractions");
        reps.CreateTest("dropdown selection", "DropDown selection to blue");
        reps.TestPASS("URL Launched Successfully");

		}
		catch(Exception e)
		{
			e.printStackTrace();
			LogManager.logger.error("URL Failed..Thorws errior");
			reps.TestFAIL("URL Launched failed!!!");
		}
	}

	@When("I select {string} from the dropdown")
	public void i_select_from_the_dropdown(String dropdowntext) {
		try
		{
	  hpage.NavigatetoDropdownpage();
	  LogManager.logger.info("Menu Navigated");
	  reps.TestPASS("Menu Navigated Successfully");
      
	  dpage.SelectDropdown(dropdowntext);
	  LogManager.logger.info("DropDown Selected");
	  reps.TestPASS("Dropdown Selected Successfully");

	  

		}
		catch(Exception e)
		{
			reps.TestFAIL("Menu Navigated Failed or dropdown Failed!!!");
			LogManager.logger.error("Failed in dropdown selection");
		}
	}

	@Then("the selected option should be {string}")
	public void the_selected_option_should_be(String dropdowntext) {
		try
		{
		dpage.AssertDropDown(dropdowntext);
		 LogManager.logger.info("DropDown matched with"+dropdowntext);
		  reps.TestPASS("Dropdown matched");
		  reps.FlushReports();
		  dm.TearDownDriver();
		  
		}
		catch(Exception e)
		{
			LogManager.logger.error("Failed in dropdown selection");
			reps.TestFAIL("Dropdown not matched!!!");
			reps.FlushReports();
			 dm.TearDownDriver();
		}
	   
	}


	
}
