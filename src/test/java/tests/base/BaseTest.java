package tests.base;

import common.CommonActions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.contactUs.ContactUsPage;
import pages.faq.FaqPage;
import pages.main.MainPage;
import pages.order.OrderPage;
import pages.reviewCategory.ReviewCategory;

public class BaseTest {

    public BasePage basePage;
    public MainPage mainPage;
    public OrderPage orderPage;
    public ContactUsPage contactUsPage;
    public FaqPage faqPage;
    public ReviewCategory reviewCategory;

    public void startDriver (String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "main" :
                driver = CommonActions.createDriver("CHROME", 1024, 1366);
                break;
            case "contactUs" :
                driver = CommonActions.createDriver("CHROME", 360, 640);
                break;
            case "faq" :
                driver = CommonActions.createDriver("CHROME", 640, 360);
                break;
            case "review" :
                driver = CommonActions.createDriver("CHROME", 768, 1024);
                break;
            case "reviewCategory" :
                driver = CommonActions.createDriver("CHROME", 1024, 768);
                break;
            case "order" :
                driver = CommonActions.createDriver("CHROME", 1024, 1366);
                break;
        }
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        contactUsPage = new ContactUsPage(driver);
        faqPage = new FaqPage(driver);
        reviewCategory = new ReviewCategory(driver);
    }

    @AfterEach
    public void clearCookiesAndExit () {
        basePage.clearCookiesAndLocalStorageAndClose();
    }
}
