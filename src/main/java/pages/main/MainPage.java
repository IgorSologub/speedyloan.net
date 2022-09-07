package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.lang.management.ManagementFactory;

public class MainPage extends BasePage {

    public MainPage (WebDriver driver) {super(driver);}

    private final By getStartedNowButton = By.xpath("//a[@class='PhrkB8V RMH-K6t K-LFdy3 words chars splitting']");
    private final By getStartedNowInFooterButton = By.xpath("//a[@class='PhrkB8V RMH-K6t K-LFdy3 V7klLSTPqa words chars splitting']");

    public MainPage getStartedNowButtonClick () {
        driver.findElement(getStartedNowButton).click();
        return this;
    }

    public MainPage readMoreButtonClick (int numButton) {
        By readMoreButton = By.xpath("(//a[@class='PhrkB8V words chars splitting'])[" + numButton + "]");
        driver.findElement(readMoreButton).click();
        return this;
    }

    public MainPage getStartedNowInFooterButtonClick () {
        driver.findElement(getStartedNowInFooterButton).click();
        return this;
    }

}
