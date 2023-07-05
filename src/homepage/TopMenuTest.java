package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";


    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));


    }


    @Before
    public void  setUp(){

        openingBrowser(baseUrl);
    }
    @Test
    public void verifyPageNavigation(){

        selectMenu("Computers");


    }
}
