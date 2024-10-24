package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.FiltersPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class FiltersSteps {
    FiltersPage sortFiltersPage = new FiltersPage();

    @Step
    public void clickFilterButton() {
        log.info("Click filer Button");
        sortFiltersPage.getFilterButton().shouldBe(visible).click();
    }

    @Step
    public void clickSortButton() {
        log.info("Click sort button");
        sortFiltersPage.getSortButton().shouldBe(visible).click();
    }

    @Step
    public void enterMinPrice(String price) {
        log.info("Enter min price: {}", price);
        sortFiltersPage.getMinPriceField().setValue(price);
    }

    @Step
    public void enterMaxPrice(String price) {
        log.info("Enter max price: {}", price);
        sortFiltersPage.getMaxPriceField().setValue(price);
    }

    @Step
    public void selectFilterItem(String filterName, String item) {
        log.info("In filter: {}, select item: {}", filterName, item);
        sortFiltersPage.getFilterNameField(filterName).scrollTo();
        sortFiltersPage.getFilterItem(item).shouldBe(visible).click();
    }

    @Step
    public void clickApplyButton() {
        log.info("Click apply button");
        sortFiltersPage.getApplyButton().click();
    }

    @Step
    public void clickResetButton() {
        log.info("Click reset button");
        sortFiltersPage.getResetButton().click();
    }

    @Step
    public boolean isLabelDisplayed(String label) {
        Utils.sleep(1500);
        log.info("Labels '{}' is displayed", label);
        return sortFiltersPage.getLabels(label).first().isDisplayed();
    }
}
