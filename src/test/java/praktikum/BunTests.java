package praktikum;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import praktikum.helpers.XxxToNullMapper;

import static praktikum.helpers.Constants.*;
import static praktikum.helpers.SpecialCharactersDetector.detectSpecialCharacters;

@RunWith(JUnitParamsRunner.class)
public class BunTests extends TestBase {

    @Test
    @FileParameters(
            mapper = XxxToNullMapper.class,
            value = "src/test/resources/BanTestDataSource.csv"
    )
    public void testGetNameReturnsCorrectBunName(String name, float price) {
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        String bunName = bun.getName();

        // Assert
        Assert.assertEquals(String.format("Ожидалось, что будет возвращено имя %s. \n" +
                "Фактически вернулось: %s", name, bunName), name, bunName);
        Assert.assertNotNull("Название булочки не может иметь значение null.", bunName);
        Assert.assertFalse("Название булочики не должно быть пустым.", bunName.isEmpty());
        Assert.assertFalse("Название булочки не должно содержать спец символы.",
                detectSpecialCharacters(bunName));
        Assert.assertTrue(String.format("Название булочки должно содержать более %d символов.", MIN_BUN_NAME_VALUE),
                name.length() >= MIN_BUN_NAME_VALUE);

        Assert.assertTrue(String.format("Название булочки не должно содержать более %d символов", MAX_BUN_NAME_VALUE),
                name.length() <= MAX_BUN_NAME_VALUE);
    }

    @Test
    @FileParameters(
            mapper = XxxToNullMapper.class,
            value = "src/test/resources/BanTestDataSource.csv"
    )
    public void testGetPriceReturnsCorrectBunPrice(String name, float price) {
        // Arrange
        Bun bun = new Bun(name, price);

        // Action
        float bunPrice = bun.getPrice();

        // Assert
        Assert.assertEquals(String.format("Ожидалось, что будет возвращена цена %.2f. Фактически полученная цена - %.2f",
                price, bunPrice), price, bunPrice, 0.01f);
        Assert.assertTrue("Цена булочки не должна быть равна нулю.", bunPrice != 0);
        Assert.assertTrue("Цена булочки не должна быть отрицательной.", bunPrice > 0);
        Assert.assertTrue(String.format("Цена булочки не может быть меньше %f.2", MIN_BUN_PRICE),
                bunPrice > MIN_BUN_PRICE);
        Assert.assertTrue(String.format("Цена булочки не может быть больше %f.2", MAX_BUN_PRICE),
                bunPrice < MAX_BUN_PRICE);
    }

}
