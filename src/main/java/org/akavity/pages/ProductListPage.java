package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ProductListPage {
    private final SelenideAppiumCollection addToCartButtons = $$(AppiumBy.xpath("//android.widget.Button[@content-desc='В корзину']"));
    private final SelenideAppiumCollection addToComparisonButtons = $$(AppiumBy.xpath("//com.horcrux.svg.SvgView[@resource-id='ComparisonIcon']"));

    public SelenideAppiumElement getTitleField(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumElement getTextUnderFigure(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[contains(@text,'" + text + "')] " +
                "| //android.widget.TextView[contains(@text,'" + text + "')]"));
    }

    public SelenideAppiumCollection getAddToFavoritesButton(String text) {
        return $$(AppiumBy.xpath("//android.widget.Button[contains(@text,'" + text + "')]/../android.widget.Button//com.horcrux.svg.SvgView"));
    }

    public SelenideAppiumCollection getAddToCartButtons() {
        return addToCartButtons;
    }

    public SelenideAppiumCollection getAddToComparisonButtons() {
        return addToComparisonButtons;
    }
}
