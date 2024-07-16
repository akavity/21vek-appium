package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.BannerData;
import org.akavity.models.PromoData;
import org.akavity.models.SpecialOfferData;
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
    @Test(description = "Checking promo buttons",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPromo(PromoData promoData) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickPromoButton(promoData.getPromo());

        Assert.assertTrue(productListSteps.isTitleDisplayed(promoData.getTitle()));
    }

    @TestData(jsonFile = "bannerData", model = "BannerData")
    @Test(description = "Checking banner buttons",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectBanner(BannerData bannerData) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickBannerButton(bannerData.getText());

        Assert.assertTrue(homeSteps.isUrlDisplayed(bannerData.getUrl()));
    }

    @TestData(jsonFile = "specialOfferData", model = "SpecialOfferData")
    @Test(description = "Checking special offer buttons",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSpecialOfferButton(SpecialOfferData specialOffer) {
        popUpsSteps.clickAllowButton();
        homeSteps.clickSpecialOfferButton(specialOffer.getOffer());

        Assert.assertTrue(homeSteps.isDiscountTypeLabelDisplayed(specialOffer.getLabel()));
    }
}
