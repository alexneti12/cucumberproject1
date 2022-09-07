package cucumberproject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class GeneralOperationsSteps {



    public static WebDriver driver;

    @Before
    public void setDriver() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() throws Throwable {
        driver.quit();
    }

    @Given("I am on the ebay main page")
    public void iAmOnTheEbayMainPage() throws Throwable {
        driver.get("https://www.ebay.com");
        Thread.sleep(2000);
    }

    @And("I accept the cookies")
    public void iAcceptTheCookies() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//button[@id='gdpr-banner-accept']"));
        element.click();
        Thread.sleep(1000);
    }
    @When("I search for a {string}")
    public void i_search_for_a(String string) throws Throwable {
        WebElement element = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        // Enter something to search for
        element.sendKeys(string);
        // Submit the form. WebDriver will find the form for us from the element
        element.submit();
    }
    @Then("The page title should start with {string}")
    public void the_page_title_should_start_with(String string)  throws Throwable {
        // Search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(string);
            }
        });
    }

    @When("I click on shopping cart icon")
    public void iClickOnShoppingCartIcon() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://cart.payments.ebay.com/sc/view']"));
        element.click();
        Thread.sleep(1000);
    }

    @Then("I should don´t have any items in my cart")
    public void iShouldDonTHaveAnyItemsInMyCart() throws Throwable  {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'have any items in your cart')]"));
    }

    @And("I click on start shopping button")
    public void iClickOnStartShoppingButton() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.ebay.com']"));
        element.click();
        Thread.sleep(1000);
    }


    @Then("Verify that I am back on the ebay main page")
    public void verifyThatIAmBackOnTheEbayMainPage() throws Throwable {
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.ebay.com/"))
        {
            System.out.println(url + " is correct");
        }
        else
        {
            System.out.println(url + " is not correct");
            fail();
        }

        //OR
        Assertions.assertEquals(url, "https://www.ebay.com/");

    }

    @When("I click on {string} link")
    public void iClickOnLink(String linkName) throws Throwable {
        WebElement element = null;

        switch (linkName)
        {
            case "Sign in":
                element = driver.findElement(By.xpath("//span[@id='gh-ug']/a"));
                break;
            case "register":
                element = driver.findElement(By.xpath("//span[@id='gh-ug-flex']/a"));
                break;
            default:
                System.out.println(linkName + " is not correct");
                fail();
                break;
        }

        element.click();
        Thread.sleep(1000);
    }

    @Then("Verify that I am on {string} page")
    public void verifyThatIAmOnPage(String pageName) {
        String url = driver.getCurrentUrl();;

        switch (pageName)
        {
            case "Sign in":
                Assertions.assertTrue(url.contains("https://signin.ebay.com/"));
                break;
            case "register":
                Assertions.assertTrue(url.contains("https://signup.ebay.com/"));
                break;
            default:
                System.out.println(pageName + " is not correct");
                fail();
                break;
        }
    }

    @And("I Click on the first product in the results")
    public void iClickOnTheFirstProductInTheResults() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//div[@id='srp-river-results']/ul/li[2]/div[1]/div[1]"));
        element.click();
        Thread.sleep(1000);
    }

    @And("I Click on Buy Add to cart Button")
    public void iClickOnBuyAddToCartButton() throws Throwable  {
    }

    @Then("Verify that product is in the shopping cart")
    public void verifyThatProductIsInTheShoppingCart() throws Throwable  {

    }

    @And("I enter {string}")
    public void iEnter(String arg0) {
    }

    @And("I enter {string} and click on Continue button")
    public void iEnterAndClickOnContinueButton(String arg0) {
        
    }

    @And("I enter {string} and click on Sign In button")
    public void iEnterAndClickOnSignInButton(String arg0) {
        
    }

    @Then("Verify that I am Signed in on Ebay")
    public void verifyThatIAmSignedInOnEbay() {
    }
}
