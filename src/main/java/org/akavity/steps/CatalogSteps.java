package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();

    @Step
    public void clickSectionButton(String text) {
        log.info("Click section button: {}", text);
        catalogPage.getSectionButton(text)
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void clickSubsectionButton(String text) {
        log.info("Click subsection button: {}", text);
        catalogPage.getSubsectionButton(text)
                .shouldBe(visible)
                .click(tap());
    }
}
