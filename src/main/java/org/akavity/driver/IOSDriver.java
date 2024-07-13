package org.akavity.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.net.MalformedURLException;
import java.net.URL;

@ParametersAreNonnullByDefault
public class IOSDriver implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13");
        options.setApp(System.getProperty("user.dir") + "/apps/iOS-Simulator-MyApp.zip");

        try {
            return new io.appium.java_client.ios.IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
