import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameCorrectMethodTest() {
        Bun bun = new Bun("black bun", 100);
        String expectedName = "black bun";
        String actualName = bun.getName();
        assertEquals("Method incorrect", expectedName, actualName);
    }

    @Test
    public void getPriceCorrectMethodTest() {
        Bun bun = new Bun("black bun", 100);
        float expectedPrice = 100;
        float actualPrice = bun.getPrice();
        assertEquals("Method incorrect", expectedPrice, actualPrice, 0);
    }


}

