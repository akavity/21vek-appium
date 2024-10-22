package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TabBarPage {
    public SelenideAppiumElement getCartCounter(String count) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='Корзина']//android.widget.TextView[@text='" + count + "']"));
    }

    public SelenideAppiumElement getTabBarItem(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }
}
