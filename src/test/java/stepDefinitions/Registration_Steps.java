package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import pages.RegisterPage;
import utilities.BaseDriver;
import utilities.ConfigReader;
import utilities.DataParser;

import java.util.List;

public class Registration_Steps {

    RegisterPage registerPage = new RegisterPage();

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        BaseDriver.getDriver().get(ConfigReader.getRegisterUrl());
    }

    @When("I fill in the registration form with valid data from {string}")
    public void iFillInTheRegistrationFormWithValidDataFrom(String dataFile) {
        fillRegisterFormWithData(dataFile);

    }

    @And("I submit the registration form")
    public void iSubmitTheRegistrationForm() {
        registerPage.clickRegisterButton();
    }

    @Then("I should see a {string} message")
    public void iShouldSeeASuccessMessage(String message) {
        Assert.assertTrue(registerPage.getSuccessMessageText().contains(message));
    }


    @When("I fill in the registration form with an existing username from {string}")
    public void iFillInTheRegistrationWithAnExistingUsernameFrom(String dataFile) {

        fillRegisterFormWithData(dataFile);

    }

    @Then("I should see {string} message on {string} title")
    public void iShouldSeeMessageOnTitle(String message, String element) {
        Assert.assertTrue(registerPage.getErrorMessage(element).contains(message));
    }

    @And("I fill in the registration form with an empty field by following details")
    public void iFillInTheRegistrationFormWithAnEmptyFieldByFollowingDetails(DataTable dataTable) {
        List<List<String>> table = dataTable.asLists(String.class);
        List<String> dataList = table.stream().flatMap(List::stream).toList();
        String[] data = dataList.stream().map(value -> value != null ? value : "").toArray(String[]::new);

        registerPage.fillRegistrationForm(data);
    }


    protected void fillRegisterFormWithData(String dataFile) {
        List<String[]> dataList = DataParser.parseData("src/test/resources/data/Registration/" + dataFile);
        for (String[] data : dataList) {
            registerPage.fillRegistrationForm(data);
        }
    }
}
