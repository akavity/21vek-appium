package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CatalogPage {

    public SelenideAppiumElement getSectionButton(String text) {
        return $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + text + "']/android.view.ViewGroup"));
    }

    public SelenideAppiumElement getSubsectionButton(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }
}
