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
    AppBarSteps appBarSteps = new AppBarSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    AccountSteps accountSteps = new AccountSteps();
    CartSteps cartSteps = new CartSteps();

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

    @TestData(jsonFile = "searchData", model = "SearchData")
    @Test(description = "Find and add a product to the cart",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void searchProduct(SearchData searchData) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        appBarSteps.clickOnSearchField();
        appBarSteps.enterTextIntoSearch(searchData.getText());
        productListSteps.clickFirstAddToCartButton();
        tabBarSteps.selectTabBarItem(searchData.getItem());

        Assert.assertTrue(cartSteps.isTitleDisplayed(searchData.getTitle()));
    }

    @TestData(jsonFile = "popProductData", model = "PopProductData")
    @Test(description = "Select a popular product from the search",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPopularProductFromSearch(PopProductData pop) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        appBarSteps.clickOnSearchField();
        appBarSteps.clickPopularProduct(pop.getProduct());

        Assert.assertTrue(productListSteps.isTitleDisplayed(pop.getTitle()));
    }

    @TestData(jsonFile = "favoritesData", model = "FavoritesData")
    @Test(description = "Add product to favorites",
            dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void addProductToFavorites(FavoritesData favorites) {
        popUpsSteps.clickAllowButton();
        popUpsSteps.closeUpdateInfo();
        appBarSteps.clickOnSearchField();
        appBarSteps.enterTextIntoSearch(favorites.getProductName());
        productListSteps.clickAddToFavoritesButton(favorites.getProductName());
        tabBarSteps.selectTabBarItem(favorites.getItem());

        Assert.assertTrue(productListSteps.isTextUnderFigureDisplayed(favorites.getProductName()));
    }
}
