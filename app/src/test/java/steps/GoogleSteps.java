package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on ther Google seach page$")
    public void navigateToGoogle(){

        google.navigateToGoogle();
        
    }

    @When("^I enter a search criteria$")
    public void enterSeachCriteria(){
        google.enterSearchCriteria("Argentina");

    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGooglesearch();
    }

    @Then("^the results march the criteria$")
    public void validateResults(){
        Assert.assertEquals("Texto que esperamos",google.firstResult());

    }

    
}
