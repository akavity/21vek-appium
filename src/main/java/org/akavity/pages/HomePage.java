package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement getPromoButton(String text) {
        return $(By.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }

    public SelenideElement getBannerButton(String text) {
        return $(By.xpath("//android.view.ViewGroup[@content-desc='" + text + "']"));
    }

    public SelenideElement getChromeUrlField(String text) {
        return $(By.xpath("//android.widget.EditText[@text='" + text + "']"));
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
