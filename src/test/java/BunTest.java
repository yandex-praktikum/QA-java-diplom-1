import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;
    String name;
    float price;

    @Before
    public void setUp() {
        name = "Хлеб";
        price = 123.45f;
        bun = new Bun(name,price);
    }

    @Test
    public void whenCallGetNameThenReturnStringTest() {
        String expected = name;

        String actual = bun.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void whenCallGetPriceThenReturnFloatTest() {
        float expected = price;

        float actual = bun.getPrice();

        assertEquals(expected, actual, 0);
    }
}