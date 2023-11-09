import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParameterizedBun {
    private final String name;
    private final float price;

    public TestParameterizedBun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][]{
                {"white bun", 200},
                {"red bun", 300},
                {"", 0},
                {null, -10},
                {"750492", 90.156f},
        };
    }

    @Test
    public void createGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void createGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
