package praktikum;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    Bun bun;
    String name;
    float price;
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Модель булочки для бургера. Тестовые данные: {0} {1}")
    public static Object[][] getTestValues() {
        return new Object[][]{
                {"Moskovskaya", 25},
                {"Saharnaya", 10.01f}
        };
    }
    @Before
    public void createBun() {
        bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        String expectedName = name;
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, bun.getPrice(), 0.0);
    }
}