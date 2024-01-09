import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("black bun", 100);
        String actualResult = bun.getName();
        String expectedResult = "black bun";

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("white bun", 200);
        Float actualResult = bun.getPrice();
        Float expectedResult = 200F;

        assertEquals(expectedResult, actualResult);

    }
}
