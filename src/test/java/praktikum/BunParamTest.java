package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class BunParamTest {
    private static final String LONG_NAME_BUN = RandomStringUtils.randomAlphabetic(100);
    private static final String SPECIAL_NAME_BUN = RandomStringUtils.random(10, ' ', '.', '/', ',', '|', '!', '@', '$', '%');

    private final String bunName;
    private final float bunPrice;
    @Mock
    Bun bun;

    public BunParamTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Проверка возвращаемого значения в зависимости от переданного. Тестовые данные: {0} : {1}")
    public static Object[][] setBun() {
        return new Object[][]{
                {"", -1.4f},
                {null, 0},
                {LONG_NAME_BUN, Float.MIN_VALUE},
                {SPECIAL_NAME_BUN, Float.MAX_VALUE}
        };
    }

    @Test
    public void returnActualNameAndPrice() {
        bun = new Bun(bunName, bunPrice);
        Assert.assertEquals("Наименование булочки неверное", bunName, bun.getName());
        Assert.assertEquals("Цена за булочку не совпадает", bunPrice, bun.getPrice(), 0);
    }
}
