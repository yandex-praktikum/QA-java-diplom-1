import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Черная", 100},
                {"Французкая", 150},
                {"Класическая", 70}
        };
    }

    @Test
    public void checkGetName() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void checkGetPrice() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        assertEquals(price, actualPrice, 0);
    }
}
