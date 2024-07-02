package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.PromoData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.akavity.steps.HomeSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.steps.ProductListSteps;
import org.akavity.utils.JsonReader;

public class MainTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productList = new ProductListSteps();

    @TestData(jsonFile = "promoData", model = "PromoData")
    @Test(description = "Navigate through the promo",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void navigateThroughThePromo(PromoData promoData) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickPromoButton(promoData.getPromo());
       Assert.assertTrue(productList.isTitleDisplayed(promoData.getPromo()));
    }
}
