package ui;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static utils.RunProperties.getWebPortalAddress;
import static drivers.DriverFactory.driver;

public class StartPage {
    
    public void open() {

        driver.get(getWebPortalAddress());
    }

    public void close() {

        driver.quit();
    }
}

