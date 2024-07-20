package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.AccountPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class AccountSteps {

    AccountPage accountPage = new AccountPage();

    @Step
    public void changeLocation(String city) {
        log.info("Click Location button");
        accountPage.getLocationButton()
                .shouldBe(visible)
                .click(tap());
        log.info("Click select location button");
        accountPage.getSelectLocationButton()
                .shouldBe(visible)
                .click(tap());
        log.info("Select city");
        accountPage.getCityButton(city)
                .shouldBe(visible)
                .click(tap());
        log.info("Click save city button");
        accountPage.getSaveCityButton()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public boolean isCityDisplayed(String city) {
        accountPage.getLocationButton().shouldBe(visible);
        boolean result = accountPage.getCityButton(city).isDisplayed();
        log.info("Is city displayed: {}", result);
        return result;
    }
}
