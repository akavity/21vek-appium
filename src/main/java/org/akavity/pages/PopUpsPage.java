package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class PopUpsPage {

    private final SelenideElement allowButton = $(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));

    public SelenideElement getAllowButton() {
        return allowButton;
    }
}
