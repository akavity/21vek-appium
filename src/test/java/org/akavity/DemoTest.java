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
        popUpsSteps.closeUpdateInfo();
        homeSteps.clickPromoButton(promoData.getPromo());

        Assert.assertTrue(productListSteps.isTitleDisplayed(promoData.getTitle()));
    }

    @TestData(jsonFile = "bannerData", model = "BannerData")
    @Test(description = "Checking banner buttons",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectBanner(BannerData bannerData) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        homeSteps.clickBannerButton(bannerData.getText());

        Assert.assertTrue(homeSteps.isUrlDisplayed(bannerData.getUrl()));
    }

    @TestData(jsonFile = "specialOfferData", model = "SpecialOfferData")
    @Test(description = "Checking special offer buttons",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectSpecialOfferButton(SpecialOfferData specialOffer) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        homeSteps.clickSpecialOfferButton(specialOffer.getOffer());

        Assert.assertTrue(homeSteps.isDiscountTypeLabelDisplayed(specialOffer.getLabel()));
    }

    @TestData(jsonFile = "catalogData", model = "CatalogData")
    @Test(description = "Navigating through the catalog",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void moveThroughCatalog(CatalogData catalog) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        tabBarSteps.selectTabBarItem(catalog.getItem());
        catalogSteps.clickSectionButton(catalog.getSection());
        catalogSteps.clickSubsectionButton(catalog.getSubsectionFirst());
        catalogSteps.clickSubsectionButton(catalog.getSubsectionSecond());

        Assert.assertTrue(productListSteps.isTitleDisplayed(catalog.getTitle()));
    }

    @TestData(jsonFile = "locationData", model = "LocationData")
    @Test(description = "Select a location",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectLocation(LocationData location) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        tabBarSteps.selectTabBarItem(location.getItem());
        accountSteps.changeLocation(location.getCityButton());

        Assert.assertTrue(accountSteps.isCityDisplayed(location.getCityField()));
    }

    @TestData(jsonFile = "accountData", model = "AccountData")
    @Test(description = "Log into the account",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void loginToAccount(AccountData account) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        tabBarSteps.selectTabBarItem(account.getItem());
        accountSteps.clickLoginToAccountButton();
        accountSteps.enterEmail(account.getEmail());
        accountSteps.enterPassword(account.getPassword());
        accountSteps.clickLoginToAccountButton();

        Assert.assertTrue(accountSteps.isPhoneNumberDisplayed());
    }
}
