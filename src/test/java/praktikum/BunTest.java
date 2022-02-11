package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    Bun bun = new Bun("Тест", 3223);

    @Test
    public void getName() {

        String actualResult = bun.getName();
        String expectedResult = "Тест";

        assertEquals("The name is not correct",expectedResult,actualResult);
    }

    @Test
    public void getPrice() {

        float actualResult = bun.getPrice();
        float expectedResult = 3223;

        assertEquals("The price is not correct",expectedResult,actualResult,0);
    }
}