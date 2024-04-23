package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaitMethods {
    private WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(2));

    protected void waitUntilClickable(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    protected void waitUntilVisible(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
