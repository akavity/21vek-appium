package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductListPage;
import org.akavity.utils.Utils;

@Log4j2
public class ProductListSteps {
    ProductListPage productList = new ProductListPage();

    @Step
    public boolean isTitleDisplayed(String title) {
        log.info("Make sure the title {} is displayed", title);
        Utils.sleep(1500);
        boolean result = productList.getTitleField(title).isDisplayed();
        log.info("Is title displayed: {}", result);
        return result;
    }

    @Step
    public boolean isTextUnderFigureDisplayed(String text) {
        log.info("Make sure the figure text {} is displayed", text);
        Utils.sleep(1500);
        boolean result = productList.getTextUnderFigure(text).isDisplayed();
        log.info("Is figure text displayed: {}", result);
        return result;
    }

    @Step
    public void clickFirstAddToCartButton() {
        log.info("Click the first button \"Add to cart\"");
        productList.getAddToCartButtons().first().click();
    }

    @Step
    public void clickAddToFavoritesButton(String product) {
        log.info("Add product to favorites");
        productList.getAddToFavoritesButton(product).first().click();
    }

    @Step
    public void clickAddToComparisonButton() {
        log.info("Add to comparison");
        productList.getAddToComparisonButtons().first().click();
    }
}
