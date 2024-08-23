package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class PopUpsSteps {
    PopUpsPage popUps = new PopUpsPage();

    @Step
    public void clickAllowButton() {
        log.info("Click allow button");
        popUps.getAllowButton()
                .shouldBe(visible)
                .click(tap());
    }
}
