package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class ProductListPage {
    private final SelenideAppiumCollection addToCartButtons = $$(AppiumBy.xpath("//android.widget.Button[@content-desc='В корзину']"));
    private final SelenideAppiumCollection addToComparisonButtons = $$(AppiumBy.xpath("//android.widget.Button[@content-desc]/android.view.ViewGroup[2]"));

    public SelenideAppiumElement getTitleField(String text) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + text + "']"));
    }

    public SelenideAppiumElement getTextUnderFigure(String text) {
        return $(AppiumBy.xpath("//android.widget.Button[contains(@text,'" + text + "')]"));
    }

    public SelenideAppiumCollection getAddToFavoritesButton(String text) {
        return $$(AppiumBy.xpath("//android.widget.Button[contains(@content-desc, 'Добавить') and contains( @content-desc, '" + text + "')]"));
    }

    public SelenideAppiumCollection getAddToCartButtons() {
        return addToCartButtons;
    }

    public SelenideAppiumCollection getAddToComparisonButtons() {
        return addToComparisonButtons;
    }
}
