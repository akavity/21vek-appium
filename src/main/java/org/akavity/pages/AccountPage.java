package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AccountPage {

    private final SelenideAppiumElement loginToAccountButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Войти']"));
    private final SelenideAppiumElement locationButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Населенный пункт']"));
    private final SelenideAppiumElement selectLocationButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Выбор населенного пункта']"));
    private final SelenideAppiumElement saveCityButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Сохранить']"));

    public SelenideAppiumElement getCityButton(String city) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + city + "']"));
    }

    public SelenideAppiumElement getLoginToAccountButton() {
        return loginToAccountButton;
    }

    public SelenideAppiumElement getLocationButton() {
        return locationButton;
    }

    public SelenideAppiumElement getSelectLocationButton() {
        return selectLocationButton;
    }

    public SelenideAppiumElement getSaveCityButton() {
        return saveCityButton;
    }
}
