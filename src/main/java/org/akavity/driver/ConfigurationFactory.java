package org.akavity.driver;

import org.akavity.enums.PlatformType;

public class ConfigurationFactory {

    public String create(String platform) {

        PlatformType mobilePlatform = PlatformType.valueOf(platform.toUpperCase());
        String ConfigurationBrowse = null;

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
