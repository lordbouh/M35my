package ru.sf;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
public class StepDefinitions {
    public static final WebDriver webDriver;
    public static final ChooseRegion chooseRegion;
    public static final RegionPage regionPage;

    static {
        System.setProperty("webdriver.chrome.driver", "/home/kidney/Soft/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseRegion = new ChooseRegion(webDriver);
        regionPage = new RegionPage(webDriver);
    }
    @Given("board of advertisments {string}")
    public void board_of_advertisments(String url) {
        chooseRegion.go(url);
    }
    @Then("choose region {string}")
    public void choose_region(String region) {
        chooseRegion.searchRegion(region);
    }
    @And("assert that region is {string}")
    public void assert_that_region_is(String expectedRegion) {
        final var currentActiveRegion = regionPage.getCurrentActiveRegion();
        assertEquals(expectedRegion, currentActiveRegion);
    }
    @Then("log in without symbols")
    public void log_in_without_symbols() {
        chooseRegion.incorrect_entrance();
    }
    @And("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        final var InvalidEntrance = chooseRegion.getBlankMessage();
        assertEquals(errorMessage, InvalidEntrance);
    }
    @Then("close browser")
    public void close_browser() {
        webDriver.close();
    }
}