import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"Steps"},
        tags = "@Smoke and @Regression"
        )
public class TestRunner {

}