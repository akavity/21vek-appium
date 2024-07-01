import org.testng.Assert;
import org.testng.annotations.Test;
import steps.HomeSteps;
import steps.PopUpsSteps;
import steps.ProductListSteps;

public class MainTest extends BaseTest {
    PopUpsSteps popUpsSteps = new PopUpsSteps();
    HomeSteps homeSteps = new HomeSteps();
    ProductListSteps productList = new ProductListSteps();

    @Test
    public void navigateThroughThePromo() {
        popUpsSteps.clickAllowButton();
        homeSteps.clickPromoButton("Уценка");
       Assert.assertTrue(productList.isTitleDisplayed("Уценка"));
    }
}
