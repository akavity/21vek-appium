package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class TabBarPage {
    public SelenideElement getCartCounter(String count) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='Корзина']//android.widget.TextView[@text='" + count + "']"));
    }

    public SelenideElement getTabBarItem(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }
}
