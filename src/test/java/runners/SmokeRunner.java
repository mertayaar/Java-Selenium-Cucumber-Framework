package runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "src/test/resources/features/Registration",
        glue = "stepDefinitions",
        tags = "@Smoke",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)

public class SmokeRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public void tearDown(){
        ExtentService.getInstance().setSystemInfo("User Name",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("User","Mert Ayar");
        ExtentService.getInstance().setSystemInfo("Application Name","Testing Examples");
        ExtentService.getInstance().setSystemInfo("Operating System Info",System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department","QA");
        ExtentService.getInstance().setSystemInfo("Additional line","Additional info");
    }
}
