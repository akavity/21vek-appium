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
        SelenideElement element = home.promoButton(text);
        Utils.waitUntilClickable(element);
        element.click();
    }
}
