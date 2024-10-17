package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.TabBarPage;
import org.akavity.utils.Utils;

@Log4j2
public class TabBarSteps {
    TabBarPage tabBarPage = new TabBarPage();

    @Step
    public void selectTabBarItem(String text) {
        log.info("Select tabBar item: {}", text);
        SelenideElement element = tabBarPage.getTabBarItem(text);
        Utils.waitUntilClickable(element);
        element.click();
    }

    @Step
    public boolean isCartFull(String number) {
        boolean result = tabBarPage.getCartCounter(number).isDisplayed();
        log.info("Check if the basket is full: {}", result);
        return result;
    }
}
