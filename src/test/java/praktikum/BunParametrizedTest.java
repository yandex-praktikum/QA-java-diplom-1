package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParametrizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Название булочки: {0}, Стоимость булочки: {1}")
    public static Object[][] getValueBun() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
                {"green bun", 50},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getBunName() {
        assertEquals("Неправильное название булочки", name, bun.getName());
    }

    @Test
    public void getBunPrice() {
        assertEquals("Неправильная стоимость булочки", price, bun.getPrice(), 0);
    }
}


