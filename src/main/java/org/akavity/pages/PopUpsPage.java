package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;


public class PopUpsPage {
    private final SelenideAppiumElement allowButton = $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
    private final SelenideAppiumElement closeButton = $(AppiumBy.xpath("//android.widget.Button/com.horcrux.svg.SvgView"));
    private final SelenideAppiumElement whatIsNewField = $(AppiumBy.xpath("(//android.widget.TextView[@text='Что нового?'])[2]"));
    private final SelenideAppiumElement compareButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Сравнить']"));

    public SelenideAppiumElement getAllowButton() {
        return allowButton;
    }

    public SelenideAppiumElement getCloseButton() {
        return closeButton;
    }

    public SelenideAppiumElement getWhatIsNewField() {
        return whatIsNewField;
    }

    public SelenideAppiumElement getCompareButton() {
        return compareButton;
    }
}
