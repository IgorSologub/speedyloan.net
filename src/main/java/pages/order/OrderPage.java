package pages.order;

import org.openqa.selenium.*;
import pages.base.BasePage;

import static constants.Constant.Order.*;

public class OrderPage extends BasePage {

    public OrderPage (WebDriver driver) {super(driver);}

    private final By howMuchDoYouNeedButton = By.cssSelector("#id_field_requested_amount_0");
    private final By nextStepButton = By.cssSelector("#id_button_next_step");
    private final By emailInput = By.cssSelector("#id_field_email");
    private final By phoneNumberInput = By.cssSelector("#id_field_home_phone");
    private final By ssnInput = By.cssSelector("#id_field_last4ssn");
    private final By firstNameInput = By.cssSelector("#id_field_first_name");
    private final By secondNameInput = By.cssSelector("#id_field_last_name");
    private final By birthDateInput = By.cssSelector("#id_field_birth_date");
    private final By zipCodeInput = By.cssSelector("#id_field_zip");
    private final By streetAddressInput = By.cssSelector("#id_field_address");
    private final By timeCurrentResidenceButton = By.cssSelector("#id_field_address_length_months_4");
    private final By currentResidenceStatusButton = By.cssSelector("#id_field_own_home_1");
    private final By sourceOfIncomeButton = By.cssSelector("#id_field_income_type_1");
    private final By timeEmployedButton = By.cssSelector("#id_field_employed_months_0");
    private final By payFrequencyButton = By.cssSelector("#id_field_pay_frequency_0");
    private final By monthlyGrossIncomeButton = By.cssSelector("#id_field_monthly_income_0");
    private final By paycheckReceivedButton = By.cssSelector("#id_field_direct_deposit_0");
    private final By abaRoutingNumberInput = By.cssSelector("#id_field_bank_aba");
    private final By bankAccountTypeButton = By.cssSelector("#id_field_bank_account_type_1");
    private final By lengthOfBankAccount = By.cssSelector("#id_field_bank_account_length_months_0");
    private final By bankAccountNumberInput = By.cssSelector("#id_field_bank_account_number");
    private final By driverLicenseNumberInput = By.cssSelector("#id_field_drivers_license_number");
    private final By creditScoreButton = By.cssSelector("#id_field_credit_score_2");
    private final By socialSecurityNumberInput = By.cssSelector("#id_field_ssn");
    private final By requestCashButton = By.cssSelector("#id_button_submit");

    private OrderPage shadowDomElementClick (By cssSelector) {
        WebElement shadowHost = driver.findElement(By.cssSelector("#pr-lead-form-v3"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRoot.findElement(cssSelector);
        shadowElement.click();
        return this;
    }

    private OrderPage shadowDomElementSendKeys (By cssSelector, String keys) {
        WebElement shadowHost = driver.findElement(By.cssSelector("#pr-lead-form-v3"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        SearchContext shadowRoot = (SearchContext) javascriptExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowElement = shadowRoot.findElement(cssSelector);
        shadowElement.sendKeys(keys);
        return this;
    }

    public OrderPage nextStepButtonClick () {
        shadowDomElementClick(nextStepButton);
        return this;
    }

    public OrderPage howMuchDoYouNeedButtonClick () {
        shadowDomElementClick(howMuchDoYouNeedButton);
        return this;
    }

    public OrderPage enterEmail () {
        shadowDomElementSendKeys(emailInput, EMAIL);
        return this;
    }

    public OrderPage enterPhoneNumber () {
        shadowDomElementSendKeys(phoneNumberInput, PHONE_NUMBER);
        return this;
    }

    public OrderPage enterSsn () {
        shadowDomElementSendKeys(ssnInput, SSN);
        return this;
    }

    public OrderPage enterFirstName () {
        shadowDomElementSendKeys(firstNameInput, FIRST_NAME);
        return this;
    }

    public OrderPage enterSecondName () {
        shadowDomElementSendKeys(secondNameInput, SECOND_NAME);
        return this;
    }

    public OrderPage enterBirthDate () {
        shadowDomElementSendKeys(birthDateInput, DATE_OF_BIRTH);
        return this;
    }

    public OrderPage enterZipCode () {
        shadowDomElementSendKeys(zipCodeInput, ZIP_CODE);
        return this;
    }

    public OrderPage enterStreetAddress () {
        shadowDomElementSendKeys(streetAddressInput, STREET_ADDRESS);
        return this;
    }

    public OrderPage timeCurrentResidenceButtonClick () {
        shadowDomElementClick(timeCurrentResidenceButton);
        return this;
    }

    public OrderPage currentResidenceStatusButtonClick () {
        shadowDomElementClick(currentResidenceStatusButton);
        return this;
    }

    public OrderPage sourceOfIncomeButtonClick () {
        shadowDomElementClick(sourceOfIncomeButton);
        return this;
    }

    public OrderPage timeEmployedButtonClick () {
        shadowDomElementClick(timeEmployedButton);
        return this;
    }

    public OrderPage payFrequencyButtonClick () {
        shadowDomElementClick(payFrequencyButton);
        return this;
    }

    public OrderPage monthlyGrossIncomeButtonClick () {
        shadowDomElementClick(monthlyGrossIncomeButton);
        return this;
    }

    public OrderPage paycheckReceivedButtonClick () {
        shadowDomElementClick(paycheckReceivedButton);
        return this;
    }

    public OrderPage enterAbaRoutingNumber () {
        shadowDomElementSendKeys(abaRoutingNumberInput, ABA_ROUTING_NUMBER);
        return this;
    }

    public OrderPage bankAccountTypeButtonClick () {
        shadowDomElementClick(bankAccountTypeButton);
        return this;
    }

    public OrderPage lengthOfBankAccountButtonClick () {
        shadowDomElementClick(lengthOfBankAccount);
        return this;
    }

    public OrderPage enterBankAccountNumber () {
        shadowDomElementSendKeys(bankAccountNumberInput, BANK_ACCOUNT_NUMBER);
        return this;
    }

    public OrderPage enterDriverLicenseNumber () {
        shadowDomElementSendKeys(driverLicenseNumberInput, DRIVER_LICENSE_NUMBER);
        return this;
    }

    public OrderPage creditScoreButtonClick () {
        shadowDomElementClick(creditScoreButton);
        return this;
    }

    public OrderPage enterSocialSecurityNumber () {
        shadowDomElementSendKeys(socialSecurityNumberInput, SOCIAL_SECURITY_NUMBER);
        return this;
    }

    public OrderPage requestCashButtonClick () {
        shadowDomElementClick(requestCashButton);
        return this;
    }
}
