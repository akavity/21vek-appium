package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductListPage {
    public SelenideElement getTitleField(String text) {
        return $(By.xpath("//android.view.ViewGroup[@content-desc='" + text + "']"));
    }
}
