package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ProductListPage {
    private final SelenideAppiumCollection addToCartButtons = $$(AppiumBy.xpath("//android.widget.Button[@content-desc='В корзину']"));

    public SelenideElement getTitleField(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumCollection getAddToCartButtons() {
        return addToCartButtons;
    }
}
