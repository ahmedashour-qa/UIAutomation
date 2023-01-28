package stepDefinitions;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.CartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

public class CartStepDef {
    private WebDriver driver;
    private PageObjectManager pom;
    private CartPage cartPage = new CartPage();

    public CartStepDef(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }

    @Then("Add to cart button should be displayed")
    public void addToCartButtonShouldBeDisplayed() {
        Assert.assertTrue(pom.isElementDisplayed(cartPage.addToCartButton));
    }

    @When("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton(){
        pom.clickElement(cartPage.addToCartButton);
    }

    @Then("Product added alert should be loaded")
    public void productAddedAlertShouldBeLoaded() throws UnhandledAlertException {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, "Product added");
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
    }

    @And("User clicks on Remove Item Button")
    public void userClicksOnRemoveItemButton() {
        pom.clickElement(cartPage.deleteBtn);
    }

    @Then("Item should be removed from table")
    public void itemShouldBeRemovedFromTable() {
        Assert.assertTrue(pom.isElementDisplayed(cartPage.addedProduct));
    }
}
