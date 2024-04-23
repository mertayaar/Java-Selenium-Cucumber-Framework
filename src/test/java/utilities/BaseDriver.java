package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    private static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    private static ThreadLocal<String> _browser = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (_browser.get() == null) {
            _browser.set("chrome");
        }
        if (_driver.get() == null) {
            switch (_browser.get()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
//
//                    if (!runningFromIntellij()) {
//                        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
//
//                    }
                    _driver.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    _driver.set(new FirefoxDriver());
                    break;
                case "safari":
                    _driver.set(new SafariDriver());
                    break;
                case "edge":
                    _driver.set(new EdgeDriver());
                    break;
            }
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);

        }
        _driver.get().manage().window().maximize();
        _driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return _driver.get();
    }

    public static void quitDriver() {
        if (_driver.get() != null) {
            _driver.get().quit();
            _driver.remove();
        }
    }

    public static void setBrowser(String browser) {
        _browser.set(browser.toLowerCase());
    }

    public static boolean runningFromIntellij() {
        String classpath = System.getProperty("java.class.path");
        return classpath.contains("idea_rt.jar");
    }
}
