package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features = "src/test/resources/features/Pre-Eqal.feature",  // Correct path
	    glue = "stepDefinitions"
	)



public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    
}
