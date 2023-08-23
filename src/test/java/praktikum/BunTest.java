package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;
    private Bun bulochka;

    public BunTest(String name, float price) {
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters(name = "Булочка: {0}, цена: {1}")
    public static Object[][] createTestData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255f},
                {"Бесплатная булка", 0},
                {"Отрицательная булка", -1},
                {null, 999}

        };
    }

    @Before
    public void setUp() {
        bulochka = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void getPriceReturnCorrectPrice() {
        assertEquals(expectedPrice, bulochka.getPrice(), 0);
    }

    @Test
    public void getNameReturnCorrectName() {
        assertEquals(expectedName, bulochka.getName());
    }
}
