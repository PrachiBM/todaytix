package qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {""},
        glue = {""},
        tags = "",
        plugin = {"pretty"}
)

public class TestRunner {}