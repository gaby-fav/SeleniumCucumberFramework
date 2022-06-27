package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GridPage;

public class GridSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGrid(){
        grid.navigateToGrid();   
    }

    @Then("^I can return  the value I want$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3, 2);

        Assert.assertEquals("r: 2, c: 1", value);
    }

    @Then("^I can validate the table is displayed$")
    public void tableIsThere(){
        Assert.assertTrue("Explotó todo", grid.cellStatus());
    }

}
