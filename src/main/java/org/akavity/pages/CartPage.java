package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CartPage {
    public SelenideAppiumElement getProductTitle(String title) {
        return $(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + title + "')]"));
    }
}
