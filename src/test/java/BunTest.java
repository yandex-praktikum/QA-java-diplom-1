import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void startUp() {
        bun = new Bun("Краторная булка N-200i", 1255);
    }

    @Test
    public void getNameBunTest() {
            String expectedName = "Краторная булка N-200i";
            String actualName = bun.getName();
            assertEquals("Название булки неверно",expectedName, actualName);
        }

    @Test
    public void getPriceBunTest() {
        int expectedPrice = 1255;
        float actualPrice = bun.getPrice();
        assertEquals("Стоимость булки неверна",expectedPrice, actualPrice,0);
    }
}