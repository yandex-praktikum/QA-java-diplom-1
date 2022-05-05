package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunPriceTest {
    private final float price;
    private final float expected;

    public BunPriceTest(float price, float expected) {
        this.price = price;
        this.expected = expected;
    }

    @Parameterized.Parameters (name = "{0} - передаем цену, {1} - получаем ожидаемый результат")
    public static Object[][] getPriceTest() {
        Database database = new Database();
        return new Object[][]{
                {database.availableBuns().get(1).getPrice(), 200},
                {400.00f, 400.00f},
                {295522.12345f, 295522.12345f},
                {0, 0}
        };
    }

    @Test
    public void shouldGetABunPrice() {
        float actual = new Bun("", price).getPrice();
        assertEquals("Цена соответствует ожидаемой", expected, actual, 0);
    }

}

