package ui;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static utils.RunProperties.getWebPortalAddress;

public class StartPage {

    private WebDriver driver = DriverFactory.driver;

    public void open() {

        driver.get(getWebPortalAddress());
    }

    public void close() {

        driver.quit();
    }
}

