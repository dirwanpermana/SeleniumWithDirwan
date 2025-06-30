package runner;

import org.junit.runner.RunWith;

// import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/saucedemo",
    glue = "selenium/definitions/saucedemo",
    plugin = {"pretty",                                   
                "html:target/cucumber-report.html",          
                "json:target/cucumber-report.json",          
                "junit:target/cucumber-report.xml"          
            }
)

public class SeleniumSauceDemoRunner {
}