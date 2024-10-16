package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CartPage;
import org.akavity.utils.Utils;

@Log4j2
public class CartSteps {
    CartPage cartPage = new CartPage();

    @Step
    public boolean isTitleDisplayed(String title) {
        Utils.sleep(1000);
        boolean result = cartPage.getProductTitle(title).isDisplayed();
        if (result == true) {
            log.info("Title is displayed: {}", title);
        } else {
            log.info("Title isn't displayed: {}", title);
        }
        return result;
    }
}
