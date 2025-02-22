package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
  features = "src/test/resources/features/Changes",
  glue = "stepdefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}
