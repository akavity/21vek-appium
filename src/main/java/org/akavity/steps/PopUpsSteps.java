package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

@Log4j2
public class PopUpsSteps {
    PopUpsPage popUps = new PopUpsPage();

    @Step
    public void clickAllowButton() {
        log.info("Click allow button");
        popUps.getAllowButton()
                .shouldBe(visible)
                .click(tap());
    }

    @Step
    public void closeUpdateInfo() {
        Utils.sleep(500);
        log.info("Is update info displayed: ");
        if (popUps.getWhatIsNewField().isDisplayed()) {
            log.info("Yes. Update info id displayed");
            popUps.getCloseButton().click(tap());
        } else {
            log.info("No. Update info isn't displayed");
        }
    }
}
