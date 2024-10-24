package org.akavity.pages;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

public class FiltersPage {
    private final SelenideAppiumElement sortButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Сортировка']"));
    private final SelenideAppiumElement filterButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Фильтр']"));
    private final SelenideAppiumElement minPriceField = $(AppiumBy.xpath("//android.widget.TextView[@text='Цена']/../android.widget.EditText[@text][1]"));
    private final SelenideAppiumElement maxPriceField = $(AppiumBy.xpath("//android.widget.TextView[@text='Цена']/../android.widget.EditText[@text][2]"));
    private final SelenideAppiumElement applyButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Применить']"));
    private final SelenideAppiumElement resetButton = $(AppiumBy.xpath("//android.widget.Button[@content-desc='Сбросить']"));

    public SelenideAppiumElement getFilterNameField(String name) {
        return $(AppiumBy.xpath("//android.widget.TextView[@text='" + name + "']"));
    }

    public SelenideAppiumElement getFilterItem(String item) {
        return $(AppiumBy.xpath("//android.widget.Button[@content-desc='" + item + "']"));
    }

    public SelenideAppiumCollection getLabels(String label) {
        return $$(AppiumBy.xpath("//android.widget.TextView[@text='" + label + "']"));
    }

    public SelenideAppiumElement getSortButton() {
        return sortButton;
    }

    public SelenideAppiumElement getFilterButton() {
        return filterButton;
    }

    public SelenideAppiumElement getMinPriceField() {
        return minPriceField;
    }

    public SelenideAppiumElement getMaxPriceField() {
        return maxPriceField;
    }

    public SelenideAppiumElement getApplyButton() {
        return applyButton;
    }

    public SelenideAppiumElement getResetButton() {
        return resetButton;
    }
}
