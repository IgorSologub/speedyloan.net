package tests.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reviews.NUMBER_OF_READ_MORE_MAIN_PAGE;
import static constants.Constant.Reviews.REVIEW_TITLES;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static constants.Constant.Urls.ORDER_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
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
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test
    public void locationButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            basePage.waitOneSeconds();
            basePage.locationButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
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
    public void getStartedNowButtonTest () {
        mainPage.getStartedNowButtonClick();
        basePage.waitFiveSeconds();
        assertEquals(ORDER_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test
    public void getStartedNowInFooterButtonTest () {
        mainPage.getStartedNowInFooterButtonClick();
        basePage.waitFiveSeconds();
        assertEquals(ORDER_PAGE_URL, basePage.getCurrentUrl());
    }

}
