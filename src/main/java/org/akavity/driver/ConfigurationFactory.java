package org.akavity.driver;

import org.akavity.enums.PlatformType;

public class ConfigurationFactory {

    public String create(String platform) {

        String ConfigurationBrowse = null;
        PlatformType mobilePlatform = PlatformType.valueOf(platform.toUpperCase());

        switch (mobilePlatform) {

            case ANDROID:
                ConfigurationBrowse = AndroidDriver.class.getName();
                break;

            case IOS:
                ConfigurationBrowse = IOSDriver.class.getName();
                break;
        }
        return ConfigurationBrowse;
    }
}
