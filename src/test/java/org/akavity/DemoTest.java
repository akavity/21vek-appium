package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest extends BaseTest {

    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productListSteps = new ProductListSteps();
    TabBarSteps tabBarSteps = new TabBarSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    AccountSteps accountSteps = new AccountSteps();

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

    @TestData(jsonFile = "catalogData", model = "CatalogData")
    @Test(description = "Moving through the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveThroughCatalog(CatalogData catalog) {
        popUpsSteps.clickAllowButton();
        tabBarSteps.selectTabBarItem(catalog.getItem());
        catalogSteps.clickSectionButton(catalog.getSection());
        catalogSteps.clickSubsectionButton(catalog.getSubsectionFirst());
        catalogSteps.clickSubsectionButton(catalog.getSubsectionSecond());

        Assert.assertTrue(productListSteps.isTitleDisplayed(catalog.getTitle()));
    }

    @TestData(jsonFile = "locationData", model = "LocationData")
    @Test(description = "Select location",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectLocation(LocationData location) {
        popUpsSteps.clickAllowButton();
        tabBarSteps.selectTabBarItem(location.getItem());
        accountSteps.changeLocation(location.getCityButton());

        Assert.assertTrue(accountSteps.isCityDisplayed(location.getCityField()));
    }

    @Test
    public void loginToAccount() {
        popUpsSteps.clickAllowButton();
        tabBarSteps.selectTabBarItem("Аккаунт");
        accountSteps.clickLoginToAccountButton();
        accountSteps.enterEmail("aprlvni413@1secmail.ru");
        accountSteps.enterPassword("0e6aaa60");
        accountSteps.clickLoginToAccountButton();

        Assert.assertTrue(accountSteps.isPhoneNumberDisplayed());
    }
}
