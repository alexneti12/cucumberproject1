package cucumberproject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class BasePage {


    public static WebDriver driver;

    public static final Duration DURATION_WAIT_TIME = Duration.ofSeconds(30);

    private void verifyExisting(WebElement element, Duration waitTime) {
        WebDriverWait waitExist = new WebDriverWait(driver, waitTime);
        waitExist.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
    }

    private void verifyVisibility(WebElement element, Duration waitTime) {
        WebDriverWait waitVisible = new WebDriverWait(driver, waitTime);
        waitVisible.until(visibilityOf(element));
    }

    private void verifyClickable(WebElement element, Duration waitTime) {
        WebDriverWait waitClickable = new WebDriverWait(driver, waitTime);
        waitClickable.until(elementToBeClickable(element));
    }

    private void sendKeysElement(WebElement element, String SendKeys) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        element.sendKeys(SendKeys);
    }

    private void clickOnElement(WebElement element, Duration waitTime) {
        verifyExisting(element, waitTime);
        verifyVisibility(element, waitTime);
        verifyClickable(element, waitTime);

        element.click();
    }

    private void fillElement(WebElement element, String input, Duration waitTime) {
        verifyExisting(element, waitTime);
        verifyVisibility(element, waitTime);

        sendKeysElement(element, input);
    }

    protected void checkIfElementExist(WebElement element) {
        verifyExisting(element, DURATION_WAIT_TIME);
        verifyVisibility(element, DURATION_WAIT_TIME);
    }

    protected void fillElement(WebElement element, String input) {
        fillElement(element, input, DURATION_WAIT_TIME);
    }

    protected void checkIfElementExistAndClick(WebElement element) {
        verifyExisting(element, DURATION_WAIT_TIME);
        verifyVisibility(element, DURATION_WAIT_TIME);
        verifyClickable(element, DURATION_WAIT_TIME);
        clickOnElement(element, DURATION_WAIT_TIME);
    }

}
