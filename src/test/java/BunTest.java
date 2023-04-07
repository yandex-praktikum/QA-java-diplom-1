import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {
    private final String name;
    private final float price;

    public BunTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Дано: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"red bun", 300},
                {"Big_burger_long_name-KinKong", 3.4E+38f},
                {"", 0},
                {"1234567890", 100.6f},
                {"!@#$%^&*()",  3.4E-38f},
                {null, -300}
        };
    }

    @Test
    public void checkNameOtherDataTests() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void checkPriceOtherDataTests() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }



}
