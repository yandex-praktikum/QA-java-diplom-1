package praktikum;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BunTests extends TestBase {

    @Test
    @FileParameters("src/test/resources/BanTestDataSource.csv")
    public void testGetNameReturnsCorrectBunName(String name, float price) {
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        String bunName = bun.getName();

        // Assert
        Assert.assertEquals(String.format("Ожидалось, что будет возвращено имя %s. \n" +
                "Фактически вернулось: %s", name, bunName), name, bunName);
    }

    @Test
    @FileParameters(value = "src/test/resources/BanTestDataSource.csv")
    public void testGetPriceReturnsCorrectBunPrice(String name, float price) {
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        float bunPrice = bun.getPrice();

        // Assert
        Assert.assertEquals(String.format("Ожидалось, что будет возвращена цена %.2f. Фактически полученная цена - %.2f",
                price, bunPrice), price, bunPrice, 0.01f);
    }

}
