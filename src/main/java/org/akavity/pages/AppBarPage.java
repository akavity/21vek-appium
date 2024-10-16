package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AppBarPage {
    private final SelenideAppiumElement searchField = $(AppiumBy.xpath("//android.widget.EditText[@content-desc='Поиск товаров']"));
    private final SelenideAppiumElement closeButton = $(AppiumBy.xpath("//android.widget.TextView[@text='ЗАКРЫТЬ']"));
    private final SelenideAppiumElement loupeButton = $(AppiumBy.xpath("//com.horcrux.svg.SvgView[@resource-id='searchBtn']"));

    public SelenideAppiumElement getLastRequestField(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumElement getPopularProductField(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }

    public SelenideAppiumElement getSearchField() {
        return searchField;
    }

    public SelenideAppiumElement getCloseButton() {
        return closeButton;
    }

    public SelenideAppiumElement getLoupeButton() {
        return loupeButton;
    }
}
