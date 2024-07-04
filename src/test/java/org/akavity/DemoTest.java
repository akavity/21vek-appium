package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.BannerData;
import org.akavity.models.PromoData;
import org.akavity.steps.HomeSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.steps.ProductListSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest extends BaseTest {

    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productListSteps = new ProductListSteps();

    @TestData(jsonFile = "promoData", model = "PromoData")
    @Test(description = "Click the promo",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    void selectPromo(PromoData promoData) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickPromoButton(promoData.getPromo());

        Assert.assertTrue(productListSteps.isTitleDisplayed(promoData.getPromo()));
    }

    @TestData(jsonFile = "bannerData", model = "BannerData")
    @Test(description = "Click the banner",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    void selectBanner(BannerData bannerData) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickBannerButton(bannerData.getText());

        Assert.assertTrue(homeSteps.isUrlDisplayed(bannerData.getUrl()));
    }
}
