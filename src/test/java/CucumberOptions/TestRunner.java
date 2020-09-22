package CucumberOptions;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@Test
@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/java/Feature",
	plugin="json:target/JsonReports/cucumber-report.json",
	glue= {"StepDefination"})
	
public class TestRunner {
//tags = "@Deleteplace" )

}
