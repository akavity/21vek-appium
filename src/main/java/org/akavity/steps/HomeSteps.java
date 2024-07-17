package org.akavity.steps;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HomePage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class HomeSteps {

    HomePage home = new HomePage();

    @Step
    public void clickPromoButton(String text) {
        SelenideAppiumElement el = home.getPromoButton(text);
        log.info("Looking for the Promo button: {}", text);
        findAndClickElement(el, 442);
    }

    @Step
    public void clickBannerButton(String text) {
        SelenideAppiumElement el = home.getBannerButton(text);
        log.info("Looking for the Banner button: {}", text);
        findAndClickElement(el, 1470);
    }

    @Step
    public boolean isUrlDisplayed(String url) {
        log.info("Make sure the url {} is displayed", url);
        Utils.sleep(1500);
        boolean result = home.getChromeUrlField(url).isDisplayed();
        log.info("Is url displayed: {}", result);
        return result;
    }

    @Step
    public void clickSpecialOfferButton(String text) {
        log.info("Scroll to element: {} and click", text);
        home.getSpecialOfferChapterField().scrollTo();
        home.getSpecialOfferButton(text)
                .scrollTo()
                .click(tap());
    }

    @Step
    public boolean isDiscountTypeLabelDisplayed(String type) {
        log.info("Make sure the discount type label {} is displayed", type);
        Utils.sleep(1500);
        home.getDiscountTypeLabel(type).scrollTo();
        boolean result = home.getDiscountTypeLabel(type).isDisplayed();
        log.info("Is  discount type label ... {} ... displayed: {}", type, result);
        return result;
    }

    private void findAndClickElement(SelenideAppiumElement el, int y) {
        int count = 0;
        Utils.sleep(500);
        while (count < 3) {
            if (el.isDisplayed()) {
                log.info("The item is displayed: Click the item");
                el.click(tap());
            } else {
                log.info("The item isn't displayed: Swipe");
                Utils.swipeElementLeft(y);
            }
            count++;
        }
    }
}
