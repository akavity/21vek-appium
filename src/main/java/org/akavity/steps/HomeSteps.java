package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HomePage;
import org.akavity.utils.Utils;

@Log4j2
public class HomeSteps {
    HomePage home = new HomePage();

    @Step
    public void clickPromoButton(String text) {
        log.info("Click catalog item: {}", text);
        SelenideElement element = home.getPromoButton(text);
        Utils.waitUntilClickable(element);
        element.click();
    }

    @Step
    public void clickBannerButton(String text) {
        log.info("banner button: {}", text);
        SelenideElement element = home.getBannerButton(text);
        Utils.waitUntilClickable(element);
        element.click();
    }

    @Step
    public boolean isUrlDisplayed(String url) {
        log.info("Make sure the url {} is displayed", url);
        Utils.sleep(1500);
        boolean result = home.getChromeUrlField(url).isDisplayed();
        log.info("Is url displayed: {}", result);
        return result;
    }
}
