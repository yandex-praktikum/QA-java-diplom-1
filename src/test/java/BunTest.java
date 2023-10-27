import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    public String name;
    public float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] bun() {
        return new Object[][]{
                {"wrong bun", 0},
                {"white bun", 350},
                {"black bun", 200},
                {"red bun", 150},
                {null, 1},
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