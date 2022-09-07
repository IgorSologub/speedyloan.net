package pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static common.Config.CLEAR_COOKIES;
import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

/**
 * ///////////// This class describes common methods and methods that can be found on all pages /////////////
 * */

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By mainLogoButton = By.xpath("//a[@class='yni5Ea']");
    private final By headerMenuOpen = By.xpath("//button[@class='REPqoJ3j js-modal-btn']");
    private final By languageMenuOpen = By.xpath("//a[@class='c-menu__lng-link c-menu__lng-link--btn']");
    private final By checkLanguageMenuVisible = By.xpath("(//a[@class='c-menu__lng-link c-menu__lng-link--drop'])[1]");
    private final By getStartedNowInHeaderButton = By.xpath("//a[@class='PhrkB8V RMH-K6t words chars splitting']");

    /**
     * ///////////// Common methods /////////////
     * */

    public BasePage clearCookiesAndLocalStorageAndClose () {
        if (CLEAR_COOKIES) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
        driver.close();
        return this;
    }

    public BasePage close () {
        driver.close();
        return this;
    }

    public BasePage goToUrl (String url) {
        driver.get(url);
        return this;
    }

    public WebElement waitElementIsVisible (WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public BasePage waitElement (By element) {
        Duration duration = Duration.ofSeconds(60);
        WebElement waitElement = driver.findElement(element);
        WebDriverWait wdWait = new WebDriverWait(driver, duration);
        wdWait.ignoring(InvalidSelectorException.class, StaleElementReferenceException.class);
        wdWait.until(ExpectedConditions.visibilityOf(waitElement));
        return this;
    }

    public BasePage nextTab () {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public BasePage closeTab () {
        driver.close();
        return this;
    }

    public BasePage closeTabAndMoveToNext () {
        closeTab();
        nextTab();
        return this;
    }

    public void moveToElement (By webElement) {
        WebElement moveTo = driver.findElement(webElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(moveTo).build().perform();
    }

    public void scrollToElement (By webElement) {
        WebElement element = driver.findElement(webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitOneSeconds();
    }

    public BasePage waitThirtySeconds () {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitOneMinute() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitFiveSeconds () {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitThreeSeconds () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage waitOneSeconds () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BasePage back (String testPageUrl) {
        if (!(Objects.equals(driver.getCurrentUrl(), testPageUrl))) {
            driver.navigate().back();
        }
        return this;
    }

    public Boolean checkTitles (List<String> typeOfTitles) {
        boolean titleStatus = false;
        for (String title : typeOfTitles) {
            if (driver.getTitle().contains(title)) {
                titleStatus = true;
                break;
            }
        }
        if (!titleStatus) {
            refreshPage();
            waitOneMinute();
            for (String title : typeOfTitles) {
                if (driver.getTitle().contains(title)) {
                    titleStatus = true;
                    break;
                }
            }
        }
        if (!titleStatus) {
            outputWrongTitle();
        }
        return titleStatus;
    }

    public Boolean checkUrls (List<String> typeOfUrls) {
        boolean urlStatus = false;
        for (String url : typeOfUrls) {
            if (driver.getCurrentUrl().contains(url)) {
                urlStatus = true;
                break;
            }
        }
        if (!urlStatus) {
            refreshPage();
            waitOneMinute();
            for (String title : typeOfUrls) {
                if (driver.getTitle().contains(title)) {
                    urlStatus = true;
                    break;
                }
            }
        }
        return urlStatus;
    }

    public Boolean checkUrl (String url) {
        boolean urlStatus = false;
        if (driver.getCurrentUrl().contains(url)) {
                urlStatus = true;
        }
        if (!urlStatus) {
            refreshPage();
            waitOneMinute();
            if (driver.getCurrentUrl().contains(url)) {
                urlStatus = true;
            }
        }
        return urlStatus;
    }

    public BasePage refreshPage () {
        driver.navigate().refresh();
        return this;
    }

    public BasePage outputWrongTitle () {
        System.out.println(driver.getTitle());
        return this;
    }

    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }

    public Boolean elementVisibleCheck (By element) {
        WebElement result = driver.findElement(element);
        return result.isDisplayed();
    }

    /**
     * ///////////// Header and footer methods /////////////
     **/

    public BasePage headerButtonClick (int numButton) {
        By headerButton = By.xpath("(//a[@class='dj9xx '])[" + numButton + "]");
        driver.findElement(headerButton).click();
        return this;
    }

    public BasePage headerMenuOpen () {
        By headerButton = By.xpath("(//a[@class='dj9xx '])[2]");
        if (!elementVisibleCheck(headerButton)) {
            driver.findElement(headerMenuOpen).click();
        }
        return this;
    }

    public BasePage getStartedNowInHeaderButtonClick () {
        driver.findElement(getStartedNowInHeaderButton).click();
        return this;
    }

    public BasePage locationButtonClick(int numButton) {
        By footerButton = By.xpath("(//div[@class='UfPLM6V'])[" + numButton + "]");
        driver.findElement(footerButton).click();
        return this;
    }

    public BasePage mainLogoButtonClick () {
        driver.findElement(mainLogoButton).click();
        return this;
    }

}
