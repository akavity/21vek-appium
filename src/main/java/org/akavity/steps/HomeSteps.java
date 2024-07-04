package org.akavity.steps;

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
        log.info("Click catalog item: {}", text);
        home.getPromoButton(text)
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickBannerButton(String text) {    // will change
        log.info("banner button: {}", text);
        home.getBannerButton(text)
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public boolean isUrlDisplayed(String url) {       // will change
        log.info("Make sure the url {} is displayed", url);
        Utils.sleep(1500);
        boolean result = home.getChromeUrlField(url).isDisplayed();
        log.info("Is url displayed: {}", result);
        return result;
    }
}
