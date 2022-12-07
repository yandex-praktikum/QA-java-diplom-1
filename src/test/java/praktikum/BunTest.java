package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("black bun", 100);

    //Проверяем метод getName()
    @Test
    public void getNameCheck() {
        String expectedResult = "black bun";
        String actualResult = bun.getName();
        assertEquals("Bun name is incorrect", expectedResult, actualResult);
    }

    //Проверяем метод getPrice()
    @Test
    public void getPriceCheck() {
        float expectedResult = 100F;
        float actualResult = bun.getPrice();
        assertEquals("Bun price is incorrect", expectedResult, actualResult, 0);
    }
}