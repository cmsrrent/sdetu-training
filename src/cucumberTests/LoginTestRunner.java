package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="features",
		glue="stepImplementations",
		tags = {"@singleScenario"}
		)
public class LoginTestRunner {

}
