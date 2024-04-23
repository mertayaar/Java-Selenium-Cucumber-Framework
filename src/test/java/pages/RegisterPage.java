package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "customer.firstName")
    private WebElement inputFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement inputLastName;

    @FindBy(id = "customer.address.street")
    private WebElement inputAddress;

    @FindBy(id = "customer.address.city")
    private WebElement inputCity;

    @FindBy(id = "customer.address.state")
    private WebElement inputState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement inputZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement inputPhone;

    @FindBy(id = "customer.ssn")
    private WebElement inputSsn;

    @FindBy(id = "customer.username")
    private WebElement inputUsername;

    @FindBy(id = "customer.password")
    private WebElement inputPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement inputPasswordConfirm;

    @FindBy(css = "input[value='Register']")
    private WebElement buttonRegisterSubmit;

    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully.')]")
    private WebElement textSuccessMessage;

    @FindBy(id = "customer.username.errors")
    private WebElement errorUsername;

    @FindBy(id = "customer.firstName.errors")
    private WebElement errorFirstName;

    @FindBy(id = "customer.lastName.errors")
    private WebElement errorLastName;

    @FindBy(id = "customer.address.street.errors")
    private WebElement errorAddress;

    @FindBy(id = "customer.address.city.errors")
    private WebElement errorCity;

    @FindBy(id = "customer.address.state.errors")
    private WebElement errorState;

    @FindBy(id = "customer.address.zipCode.errors")
    private WebElement errorZipCode;

    @FindBy(id = "customer.ssn.errors")
    private WebElement errorSsn;

    @FindBy(id = "customer.password.errors")
    private WebElement errorPassword;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement errorPasswordConfirm;

    public void enterFirstName(String firstName) {
        sendKeysMethod(inputFirstName, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeysMethod(inputLastName, lastName);
    }

    public void enterAddress(String address) {
        sendKeysMethod(inputAddress, address);
    }

    public void enterCity(String city) {
        sendKeysMethod(inputCity, city);
    }

    public void enterState(String state) {
        sendKeysMethod(inputState, state);
    }

    public void enterZipCode(String zip) {
        sendKeysMethod(inputZipCode, zip);
    }

    public void enterPhoneNumber(String phone) {
        sendKeysMethod(inputPhone, phone);
    }

    public void enterSSN(String ssn) {
        sendKeysMethod(inputSsn, ssn);
    }

    public void enterUsername(String username) {
        sendKeysMethod(inputUsername, username);
    }

    public void enterPassword(String password) {
        sendKeysMethod(inputPassword, password);
    }

    public void enterRepeatedPassword(String repatedPassword) {
        sendKeysMethod(inputPasswordConfirm, repatedPassword);
    }

    public void clickRegisterButton() {
        clickMethod(buttonRegisterSubmit);
    }

    public void fillRegistrationForm(String[] data) {
        enterFirstName(data[0]);
        enterLastName(data[1]);
        enterAddress(data[2]);
        enterCity(data[3]);
        enterState(data[4]);
        enterZipCode(data[5]);
        enterPhoneNumber(data[6]);
        enterSSN(data[7]);
        enterUsername(data[8]);
        enterPassword(data[9]);
        enterRepeatedPassword(data[10]);
    }

    public String getSuccessMessageText() {
        return getTextOfElement(textSuccessMessage);
    }


    public String getErrorMessage(String elementName) {
        try {
            return switch (elementName) {
                case "errorUsername" -> getTextOfElement(errorUsername);
                case "errorFirstName" -> getTextOfElement(errorFirstName);
                case "errorLastName" -> getTextOfElement(errorLastName);
                case "errorAddress" -> getTextOfElement(errorAddress);
                case "errorCity" -> getTextOfElement(errorCity);
                case "errorState" -> getTextOfElement(errorState);
                case "errorZipCode" -> getTextOfElement(errorZipCode);
                case "errorSsn" -> getTextOfElement(errorSsn);
                case "errorPassword" -> getTextOfElement(errorPassword);
                case "errorPasswordConfirm" -> getTextOfElement(errorPasswordConfirm);
                default -> throw new IllegalStateException("Unexpected value: " + elementName);
            };
        } catch (Exception ex) {
            System.err.println("Error occurred while getting text of web element: " + ex.getMessage());
            return null;
        }
    }


}
