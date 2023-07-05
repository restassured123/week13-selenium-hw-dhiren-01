package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openingBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        mouseHover(By.xpath("//ul[@class ='top-menu notmobile']//a[text()='Electronics ']"), By.xpath("//ul[@class='sublist first-level']//a[text()='Cell phones ']"));
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expected = "Cell phones";
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully(){
        mouseHover(By.xpath("//ul[@class ='top-menu notmobile']//a[text()='Electronics ']"), By.xpath("//ul[@class='sublist first-level']//a[text()='Cell phones ']"));
        String actual = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expected = "Cell phones";
        Assert.assertEquals(expected, actual);
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        //clickOnElement(By.xpath("//img[@alt='Picture of Nokia Lumia 1020'][@title='Show details for Nokia Lumia 1020']"));





    }
}
