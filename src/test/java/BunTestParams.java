import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTestParams {

    public float price;
    String name;

    public BunTestParams(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{0} name, {1} price")
    public static Object[][] getBun() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
        };
    }

    @Test
    public void checkPrice() {
        assertEquals(name, new Bun(name, price).getName());
        assertEquals(price, new Bun(name, price).getPrice(), 1E-4);
    }

}
