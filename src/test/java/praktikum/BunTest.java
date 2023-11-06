package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Название = {0}, стоимость = {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Bread", 1.0f},
                {"", 0f},
                {"100500", Float.MAX_VALUE}
        };
    }

    @Test
    public void testGetters() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}