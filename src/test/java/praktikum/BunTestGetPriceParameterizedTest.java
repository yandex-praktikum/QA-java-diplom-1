package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class BunTestGetPriceParameterizedTest {

    private final float price;
    private final String name = "Булочка с кунжутом";

    public BunTestGetPriceParameterizedTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {0},
                {-1},
                {1},
                {-9999999},
                {9999999}
        };
    }
        @Test
        public void getPriceTest () {
            Bun bun = new Bun(name, price);
            float actualPrice = bun.getPrice();
            Assert.assertEquals("Цена не совпадает с ожидаемым значением", price, actualPrice, 0);
        }
}

