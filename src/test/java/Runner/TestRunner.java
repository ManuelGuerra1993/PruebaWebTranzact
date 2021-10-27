package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",glue = "definitions", tags = "@FlujoPrincipal",
        monochrome = true)

public class TestRunner {
}
