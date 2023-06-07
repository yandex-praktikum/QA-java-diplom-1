package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun Bun;
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.Bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters(name = "Тестовые данные: название булки [{0}], цена булки [{1}]")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Test
    public void getNameTest() {
        assertEquals("Ошибка! Неверное название булки", bunName, Bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Ошибка! Неверная цена булки", bunPrice, Bun.getPrice(), 0.0);
    }
}
