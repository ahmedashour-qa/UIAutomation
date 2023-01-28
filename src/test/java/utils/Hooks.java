package utils;

import org.junit.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;
    public Hooks(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
