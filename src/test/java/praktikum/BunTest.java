package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    private static Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSomeBun() {
        return new Object[][]{
                {"Булочка №1", 0.0f},
                {"Imported bun", 25.0f},
                {"Булочка со впечетляющим длинным названием", 100.0f},
        };
    }
    @Before
    public void initBun() {
        bun = new Bun(this.name, this.price);
    }

    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        assertEquals(this.name, actualName);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        assertEquals(this.price, actualPrice, 0);
    }

}
