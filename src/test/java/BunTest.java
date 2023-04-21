import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private String bunName;
    private float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters(name = "Название: {0}, Цена: {1}")
    public static Object[][] getDataForm() {
        return new Object[][] {
                {"Булочка с кунжутом", 12.5f},
                {"Сушёный слайм", 1000.33f},
        };
    }

    @Test
    public void getNameReturnsExpectedValue() {
        Bun bun = new Bun(bunName, bunPrice);
        String bunNameActual = bun.getName();
        assertEquals(bunName, bunNameActual);
    }

    @Test
    public void getPriceReturnsExpectedValue() {
        Bun bun = new Bun(bunName, bunPrice);
        float bunPriceActual = bun.getPrice();
        assertEquals(bunPrice, bunPriceActual);
    }

}
