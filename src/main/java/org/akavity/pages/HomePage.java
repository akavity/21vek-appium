package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class HomePage {

    public SelenideAppiumElement getSpecialOfferChapterField() {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='Все акции']"));
    }

    public SelenideAppiumElement getPromoButton(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumElement getBannerButton(String text) {
        return $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + text + "']"));
    }

    public SelenideAppiumElement getChromeUrlField(String text) {
        return $(AppiumBy.xpath("//android.widget.EditText[@text='" + text + "']"));
    }

    public SelenideAppiumElement getSpecialOfferButton(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='Все акции']/.." +
                "//android.widget.Button[@content-desc='" + text + "']"));
    }

    public SelenideAppiumElement getDiscountTypeLabel(String type) {
        return $(AppiumBy.xpath("(//android.widget.TextView[@text='Все акции']/.." +
                "//android.view.ViewGroup/android.widget.TextView[@text='" + type + "'])[1]"));
    }
}
