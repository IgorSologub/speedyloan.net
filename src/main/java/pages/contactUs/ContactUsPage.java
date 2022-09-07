package pages.contactUs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.main.MainPage;

public class ContactUsPage extends BasePage {

    public ContactUsPage (WebDriver driver) {super(driver);}

    private final By nameField = By.xpath("//input[@id='author']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By commentField = By.xpath("//textarea[@id='comment']");
    private final By commentError = By.xpath("//label[@id='comment-error']");
    private final By formMessage = By.xpath("//div[@id='form-message']");
    private final By sendMessageButton = By.xpath("//button[@class='PhrkB8V hCaxfiBm words chars splitting']");

    public ContactUsPage nameFieldSendKeys (String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public ContactUsPage emailFieldSendKeys (String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public ContactUsPage commentFieldSendKeys (String comment) {
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    public boolean commentErrorCheck () {
        return elementVisibleCheck(commentError);
    }

    public boolean formMessageCheck () {
        return elementVisibleCheck(formMessage);
    }

    public ContactUsPage sendMessageButtonClick () {
        driver.findElement(sendMessageButton).click();
        return this;
    }

}
