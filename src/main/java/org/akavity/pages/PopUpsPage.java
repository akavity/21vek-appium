package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PopUpsPage {

    private final SelenideElement allowButton = $(By.id("com.android.permissioncontroller:id/permission_allow_button"));

    public SelenideElement getAllowButton() {
        return allowButton;
    }
}
