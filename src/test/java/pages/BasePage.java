package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseDriver;
import utilities.WaitMethods;

public class BasePage extends WaitMethods {

    public BasePage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    protected void clickMethod(WebElement element) {
        waitUntilClickable(element);
        element.click();

    }

    protected void sendKeysMethod(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getTextOfElement(WebElement element){
        waitUntilVisible(element);
        return element.getText();
    }


}
