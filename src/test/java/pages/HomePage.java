package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement buttonRegister;

    public void clickRegisterButton(){
        clickMethod(buttonRegister);
    }


}
