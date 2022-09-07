package tests.reviewCategory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reviews.*;
import static constants.Constant.Urls.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewCategoryTest extends BaseTest {

    @BeforeEach
    public void setUp () {
        startDriver("reviewCategory");
        basePage.goToUrl(REVIEW_CATEGORY_URL);
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
            basePage.back(REVIEW_CATEGORY_URL);
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
    public void visitSiteButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VISIT_SITE_REVIEW_CATEGORY; i++) {
            basePage.waitOneSeconds();
            reviewCategory.visitSiteButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkUrl(ORDER_PAGE_URL)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(REVIEW_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_VISIT_SITE_REVIEW_CATEGORY, goodTitlesCount);
    }

    @Test
    public void viewProfileTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_VIEW_PROFILE_REVIEW_CATEGORY; i++) {
            basePage.waitOneSeconds();
            reviewCategory.viewProfileClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(REVIEW_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_VIEW_PROFILE_REVIEW_CATEGORY, goodTitlesCount);
    }

    @Test
    public void secondPageButtonTest () {
        basePage.waitOneSeconds();
        reviewCategory.secondPageButtonClick();
        basePage.waitFiveSeconds();
        assertTrue(reviewCategory.secondPageUrlCheck());
    }

}
