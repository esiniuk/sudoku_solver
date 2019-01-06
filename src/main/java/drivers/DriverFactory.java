package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.RunProperties.*;


public class DriverFactory {

    public static WebDriver driver = getPreparedDriver();

    private static ChromeOptions getChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty(getChromeName(), getChromePath());
        return options;
    }

    private static WebDriver getPreparedDriver() {
        if (getBrowser().equals("chrome")) {
            return new ChromeDriver(getChromeCapabilities());
        } else {
            System.err.println("Browser name wrong");
            return null;
        }
    }
}