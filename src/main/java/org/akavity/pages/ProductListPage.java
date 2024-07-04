package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class ProductListPage {

    public SelenideElement getTitleField(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }
}
