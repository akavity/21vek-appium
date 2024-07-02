package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TabBarPage {
    public SelenideElement getTabBarItem(String text) {
        return $(By.xpath("//android.widget.Button[@content-desc='" + text + "']"));
    }
}
