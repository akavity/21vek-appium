package org.akavity.steps;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HomePage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class HomeSteps {

    HomePage home = new HomePage();

    @Step
    public void clickPromoButton(String text) {
        SelenideAppiumElement el = home.getPromoButton(text);
        int count = 0;
        Utils.sleep(500);
        while (count < 3) {
            if (el.isDisplayed()) {
                log.info("Promo item is displayed: Click promo item");
                el.click(tap());
            } else {
                log.info("Promo item isn't displayed: Swipe promo item");
                Utils.swipeElementLeft(1000, 442, 180, 442, 1);
            }
            count++;
        }
    }

    @Step
    public void clickBannerButton(String text) {
        log.info("banner button: {}", text);
        home.getBannerButton(text)
                .shouldBe(visible)
                .click(tap());
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
}
