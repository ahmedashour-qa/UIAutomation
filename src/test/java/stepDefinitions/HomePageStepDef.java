package stepDefinitions;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import locators.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class HomePageStepDef {
    private WebDriver driver;
    private PageObjectManager pom;
    private HomePage homePage = new HomePage();

    public HomePageStepDef(DriverSetup driverSetup){
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Given("User opens chrome browser and navigates to the url")
    public void userOpensChromeBrowserAndNavigatesToTheUrl() {
        driver.get("https://demoblaze.com/");
    }

    @Then("Home page should be loaded")
    public void homePageShouldBeLoaded() {
        Assert.assertTrue(pom.isElementDisplayed(homePage.demoblazeLogo));
    }

    @And("Top nav bar should be visible")
    public void topNavBarShouldBeVisible() {
        Assert.assertTrue(pom.isElementDisplayed(homePage.topNavBar));
    }
}
