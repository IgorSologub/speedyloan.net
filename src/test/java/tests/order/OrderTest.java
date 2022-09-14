package tests.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.ORDER_PAGE_URL;
import static constants.Constant.Urls.ORDER_REF_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("order");
        basePage.goToUrl(ORDER_PAGE_URL);
        basePage.waitOneSeconds();
    }

    @Test
    public void orderFormTest () {
        basePage.waitFiveSeconds();

        basePage.waitThreeSeconds();
        orderPage.howMuchDoYouNeedButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterEmail();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterPhoneNumber();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterSsn();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterFirstName();
        basePage.waitOneSeconds();
        orderPage.enterSecondName();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterBirthDate();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterStreetAddress();
        basePage.waitOneSeconds();
        orderPage.enterZipCode();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.timeCurrentResidenceButtonClick();

        basePage.waitThreeSeconds();
        orderPage.currentResidenceStatusButtonClick();

        basePage.waitThreeSeconds();
        orderPage.sourceOfIncomeButtonClick();

        basePage.waitThreeSeconds();
        orderPage.timeEmployedButtonClick();

        basePage.waitThreeSeconds();
        orderPage.payFrequencyButtonClick();

        basePage.waitThreeSeconds();
        orderPage.monthlyGrossIncomeButtonClick();

        basePage.waitThreeSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.paycheckReceivedButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterAbaRoutingNumber();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.nextStepButtonClick();

        /*
        basePage.waitThreeSeconds();
        orderPage.bankAccountTypeButtonClick();
         */

        basePage.waitThreeSeconds();
        orderPage.lengthOfBankAccountButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterBankAccountNumber();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterDriverLicenseNumber();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.creditScoreButtonClick();

        basePage.waitThreeSeconds();
        orderPage.enterSocialSecurityNumber();
        basePage.waitOneSeconds();
        orderPage.nextStepButtonClick();

        basePage.waitThreeSeconds();
        orderPage.requestCashButtonClick();

        basePage.waitFiveSeconds();
        basePage.waitFiveSeconds();
        assertTrue(basePage.checkUrl(ORDER_REF_URL));
    }
}
