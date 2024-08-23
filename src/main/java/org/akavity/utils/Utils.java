package org.akavity.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {
    private static int START_X = 1000;
    private static int END_X = 180;

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitUntilClickable(SelenideElement element) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofMillis(30000));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void swipeElementLeft(int y) {
        TouchAction touch = new TouchAction(AppiumDriverRunner.getAndroidDriver());
        touch.press(PointOption.point(START_X, y))      // startY
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(END_X, y))    // endY
                .release().perform();
    }
}
