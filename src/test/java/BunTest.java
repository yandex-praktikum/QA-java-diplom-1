import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;


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
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300},
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
    public void checkGetNameValid() {
        assertEquals("Имя - name, не валидное", name, bun.getName());
    }

    @Test
    public void checkGetPriceValid() {
        assertEquals("Цена  - price, не валидна", price, bun.getPrice(), 0.0f);
    }
}

