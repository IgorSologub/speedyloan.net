package tests.contactUs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.ContactUs.*;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Urls.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("contactUs");
        basePage.goToUrl(CONTACT_US_PAGE_URL);
        basePage.waitOneSeconds();
    }

    @Test
    public void headerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.headerMenuOpen();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(CONTACT_US_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test
    public void mainLogoLinkTest () {
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test
    public void getStartedNowInHeaderButtonTest () {
        basePage.headerMenuOpen();
        basePage.waitOneSeconds();
        basePage.getStartedNowInHeaderButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(basePage.checkUrl(ORDER_PAGE_URL));
    }

    @Test
    public void successfulContactUsTest () {
        basePage.waitFiveSeconds();
        contactUsPage.nameFieldSendKeys(NAME)
                .emailFieldSendKeys(EMAIL)
                .commentFieldSendKeys(COMMENT);
        basePage.waitOneSeconds();
        contactUsPage.sendMessageButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(contactUsPage.formMessageCheck());
    }

    @Test
    public void unsuccessfulContactUsTest () {
        basePage.waitFiveSeconds();
        contactUsPage.nameFieldSendKeys(EMPTY)
                .emailFieldSendKeys(EMPTY)
                .commentFieldSendKeys(EMPTY);
        basePage.waitOneSeconds();
        contactUsPage.sendMessageButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(contactUsPage.commentErrorCheck());
    }

}
