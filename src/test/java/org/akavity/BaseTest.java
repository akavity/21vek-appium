package org.akavity;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.akavity.driver.ConfigurationFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(@Optional("platform") String platform) {
        WebDriverRunner.closeWebDriver();
        Configuration.browser = new ConfigurationFactory().create(platform);
        SelenideAppium.launchApp();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }
}
