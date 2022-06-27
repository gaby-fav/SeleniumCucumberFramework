package pages;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    features = "src/test/resources/features",
    glue = "steps",
    monochrome = true,
    tags = "@Test"
)  //si quiero mas de un tag {"@Test, @Otrotag"}

public class runner{
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
  
}