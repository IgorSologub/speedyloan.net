package pages.reviewCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.main.MainPage;

import static constants.Constant.Urls.ORDER_PAGE_URL;

public class ReviewCategory extends BasePage {

    public ReviewCategory (WebDriver driver) {super(driver);}

    private final By secondPageButton = By.xpath("(//a[@class='F0CNbG'])[1]");

    public ReviewCategory visitSiteButtonClick (int numButton) {
        By visitSiteButton = By.xpath("(//a[@class='PhrkB8V RMH-K6t V7klLSTPqa words chars splitting'])[" + numButton + "]");
        driver.findElement(visitSiteButton).click();
        return this;
    }

    public ReviewCategory viewProfileClick (int numButton) {
        By viewProfileClick = By.xpath("(//a[@class='PhrkB8V words chars splitting'])[" + numButton + "]");
        driver.findElement(viewProfileClick).click();
        return this;
    }

    public ReviewCategory secondPageButtonClick () {
        driver.findElement(secondPageButton).click();
        return this;
    }

    public boolean secondPageUrlCheck () {
        return checkUrl("https://speedyloan.net/reviews/page/2");
    }

}
