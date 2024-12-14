package Runners;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions
(
		features = "./src/main/java/features/draganddrop.feature",
		glue = "steps",
		monochrome = true
		
		)




public class Runner extends AbstractTestNGCucumberTests {

}
