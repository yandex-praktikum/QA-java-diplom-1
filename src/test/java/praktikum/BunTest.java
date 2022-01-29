package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;


public class BunTest {


    @Test
    public void bunCanHaveName() {
        Bun bun = new Bun("red bun", 300);
        String expectedName = "red bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);

    }

    @Test
    public void bunCanHavePrice() {
        Bun bun = new Bun("red bun", 300);
        float expectedPrice = 300;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 50);
    }

}
