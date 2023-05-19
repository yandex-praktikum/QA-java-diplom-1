package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BunParamTest {
    private Bun bun;
    private final String name;
    private final float price;

    public BunParamTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Данные для теста {0} {1}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {"Булочка", 10.21313f},
                {"!№;?%*№(№(;?№-_", 5.1312f},
                {"asddasa", 100},
                {"3123131", 23.123124151242f},
                {null, -10},
                {"", 0},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameReturnTrueData() {
        assertEquals("Значения названия не совпадают", name, bun.getName());
    }

    @Test
    public void getPriceReturnTrueData() {
        assertEquals("Значения цены не совпадают", price, bun.getPrice(), 0);
    }
}