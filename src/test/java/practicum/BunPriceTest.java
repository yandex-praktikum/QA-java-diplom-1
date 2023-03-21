package practicum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {
    String randomName = RandomStringUtils.randomAlphabetic(10);
    float price;

    public BunPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {1500f},
                {0},
                {-1500f},
                {0.555f}
        };
    }

    @Test
    public void getPriceShouldReturnValidPrice() {
        Bun bun = new Bun(randomName, price);
        assertEquals(price, bun.getPrice(), 0f);
    }
}