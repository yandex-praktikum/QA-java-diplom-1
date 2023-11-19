package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private final String name;
    private final float price;

    @Before
    public void beforeBenTest() {
        bun = new Bun(name, price);
    }

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getNameAndPrice() {
        return new Object[][] {
                {"Булочка с маком", (float) 100.00},
                {"Сосиска в тесте", (float) 152.50},
                {"Ватрушка", (float) 120.30},
                {"Пирожок с капустой", (float) 90.50}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Name of bun is not correct", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Price of bun is not correct", price, bun.getPrice(), 0.0f);
    }
}