package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "stepdefinitions", 
    tags = "@Regression"
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    
}
