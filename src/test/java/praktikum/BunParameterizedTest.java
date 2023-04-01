package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private final String name;
    private final float price;

    public BunParameterizedTest(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название и цена: {0}, {1}")
    public static Object[][] getBunData() {
        return new Object[][]
                {
                        {"Star M-19", -0.99f},
                        {"1394", 15.01f},
                        {"Луна", 199f},
                        {null, 0},
                };
    }


    @Test
    public void getNameReturnCorrectName() {
        Bun bun = new Bun(name, price);
        String expected = name;
        String actual = bun.getName();
        assertEquals("Проверка названия", expected, actual);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        Bun bun = new Bun(name, price);
        float expected = price;
        float actual = bun.getPrice();
        assertEquals("Проверка цены", expected, actual, 0.01);
    }
}