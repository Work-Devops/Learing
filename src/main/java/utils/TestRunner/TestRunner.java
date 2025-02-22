package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
  features = "src/test/resources/features/Changes/addvalues",
  glue = "stepdefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
