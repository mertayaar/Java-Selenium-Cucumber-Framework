package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    LocalDateTime startTime;
    LocalDateTime endTime;

    @Before
    public void beforeScenario() {
        startTime = LocalDateTime.now();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] byteImage = ((TakesScreenshot)(BaseDriver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage,"image/png",scenario.getName());
        }

        BaseDriver.quitDriver();



    }

}
