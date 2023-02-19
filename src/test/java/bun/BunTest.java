package bun;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"orange bun", 300},
                {"black bun", 150},
                {"red bun", 200},
                {null, 300},
                {"bun", 0},
                {"", 123f},
        };
    }

    @Before
    public void init() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameReturnName() {
        assertEquals("Имя не валидное!", name, bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        assertEquals("Цена не валидна!", price, bun.getPrice(), 0.0f);
    }
}
