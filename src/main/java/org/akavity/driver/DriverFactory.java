package org.akavity.driver;

import org.akavity.enums.PlatformType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverFactory {
    public AppiumDriver<MobileElement> createInstance(String platform) {

        AppiumDriver<MobileElement> driver = null;

        PlatformType mobilePlatform = PlatformType.valueOf(platform.toUpperCase());

        switch (mobilePlatform) {

            case ANDROID:
                driver = new AndroidDriverManager().createInstance();
                break;

            case IOS:
                driver = new IOSDriverManager().createInstance();
                break;
        }
        return driver;
    }
}
