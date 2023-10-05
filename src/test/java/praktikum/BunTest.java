package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Флюоресцентная булка", 10.0f);
    }

    @Test
    public void getNameShouldReturnExpectedName() {
        String expectedName = "Флюоресцентная булка";
        assertEquals("Наименования булок не совпадают", expectedName, bun.getName());
    }

    @Test
    public void getPriceShouldReturnPriceZeroDelta() {
        float expectedPrice = 10.0f;
        assertEquals("Есть разница между значениями цены", expectedPrice, bun.getPrice(), 0);
    }
}
