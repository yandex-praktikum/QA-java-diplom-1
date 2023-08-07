import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;

    private String name;

    int price;

    public BunTest(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Булочка - {0} Цена - {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Капустная", 90},
                {"Кукурузная", 99}
        };
    }

    @Before
    public void preBun() {
        bun = new Bun(name,price
        );
    }

    @Test
    public void checkGetName() {

        assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPrice() {

        assertEquals(price, bun.getPrice(), 0);
    }
}
