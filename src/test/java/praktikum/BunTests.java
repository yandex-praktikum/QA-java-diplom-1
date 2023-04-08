package praktikum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.helpers.Constants;

import static praktikum.helpers.Constants.CHECK_NAME_TEST_MESSAGE;
import static praktikum.helpers.Constants.CHECK_PRICE_TEST_MESSAGE;

@RunWith(JUnitParamsRunner.class)
public class BunTests extends TestBase {

    @Test
    @Parameters({
            Constants.BUN_NAME + "," + Constants.BUN_PRICE
    })
    public void testGetNameReturnsCorrectBunName(String name, float price){
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        String bunName = bun.getName();

        // Assert
        Assert.assertEquals(String.format(CHECK_NAME_TEST_MESSAGE,
                Constants.BUN_NAME, bunName),Constants.BUN_NAME, bunName);
    }

    @Test
    @Parameters({
            Constants.BUN_NAME + "," + Constants.BUN_PRICE
    })
    public void testGetPriceReturnsCorrectBunPrice(String name, float price){
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        float bunPrice = bun.getPrice();

        // Assert
        Assert.assertEquals(String.format(CHECK_PRICE_TEST_MESSAGE,
                Constants.BUN_PRICE, bunPrice),Constants.BUN_PRICE, bunPrice, 0.01f);
    }
}
