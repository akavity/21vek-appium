package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public SelenideElement getPromoButton(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideElement getBannerButton(String text) {
        return $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='" + text + "']"));
    }

    public SelenideElement getChromeUrlField(String text) {
        return $(AppiumBy.xpath("//android.widget.EditText[@text='" + text + "']"));
    }

    public SelenideElement getSpecialOfferButton(String text) {
        return $(By.xpath("//android.widget.TextView[@text='Все акции']/.." +
                "//android.widget.Button[@content-desc='" + text + "']"));
    }

    public SelenideElement getDiscountTypeLabel(String type) {
        return $(By.xpath("(//android.widget.TextView[@text='Все акции']/.." +
                "//android.view.ViewGroup/android.widget.TextView[@text='" + type + "'])[1]"));
    }
}
