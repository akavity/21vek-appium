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
}

