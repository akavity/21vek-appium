package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.AppBarPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class AppBarSteps {
    AppBarPage appBarPage = new AppBarPage();

    @Step
    public void clickOnSearchField() {
        log.info("Click on the search field");
        appBarPage.getSearchField().shouldBe(visible);
        appBarPage.getSearchField().click(tap());
    }

    @Step
    public void enterTextIntoSearch(String text) {
        log.info("Search text into the search");
        appBarPage.getSearchField().click();
        appBarPage.getSearchField().setValue(text);
        appBarPage.getLoupeButton().click();
    }

    @Step
    public void clickPopularProduct(String product) {
        log.info("Click popular product: {}", product);
        appBarPage.getPopularProductField(product).click();
    }
}
