package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("BunNameTest", 100.00F);

    @Test
    public void getNameBurgerTest(){
        String actualBurgerName = bun.getName();
        String expectedBurgerName = "BunNameTest";
        assertEquals(expectedBurgerName, actualBurgerName);
    }

    @Test
    public void getPriceBurgerTest(){
        float actualBurgerPrice = bun.getPrice();
        float expectedBurgerPrice = 100.00F;
        assertEquals(expectedBurgerPrice, actualBurgerPrice, 0.0f);
    }
}
