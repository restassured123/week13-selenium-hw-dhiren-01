package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import javax.xml.bind.annotation.XmlEnum;
import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openingBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"), "6");

        List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'details']//a"));
        //verify descending order
        boolean isDescending = true;
        for (int i = 0; i < items.size() - 1; i++) {
            String currentElement = items.get(i).getText();
            String nextElement = items.get(i + 1).getText();
            if (currentElement.compareTo(nextElement) > 0) {
                isDescending = false;
                break;
            }
        }
        if (isDescending) {
            System.out.println("Elements are in descending order.");
        } else {
            System.out.println("Elements are not in descending order.");
        }

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"), "5");
        //2.4 Click on "Add To Cart"
        //clickOnElement(By.xpath(""));

        //Verify the Text "Build your own computer"
        String actualText = getTextFromElement(By.xpath("//a[contains(text(),'Build your own computer')]"));
        String expectedText = "Build your own computer";
        Assert.assertEquals(expectedText, actualText);
        //select processor
        selectByValueFromDropDown(By.id("product_attribute_1"), "1");
        selectByValueFromDropDown(By.id("product_attribute_2"), "5");
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        clickOnElement(By.id("product_attribute_5_12"));







    }

    @After
    public void tearDown() {

        closingBrowser();
    }
}
