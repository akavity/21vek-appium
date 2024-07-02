package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;
import org.akavity.utils.Utils;

@Log4j2
public class PopUpsSteps {

    PopUpsPage popUps = new PopUpsPage();

    @Step
    public void clickAllowButton() {
        log.info("Click allow button");
        Utils.waitUntilClickable(popUps.getAllowButton());
        popUps.getAllowButton().click();
    }

}
