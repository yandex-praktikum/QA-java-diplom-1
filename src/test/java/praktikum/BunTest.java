package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    String testName = "testName";
    float testPrice = 111;

    @Test
    public void getNameTest() {
        Bun bun = new Bun(testName, 1);
        String expectedResult = "testName";
        String actualResult = bun.getName();
        assertEquals("getName method (class Bun) doesn't work correctly", expectedResult, actualResult);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun("mockName", testPrice);
        float expectedResult = 111;
        float actualResult = bun.getPrice();
        assertEquals("getPrice method (class Bun) doesn't work correctly", expectedResult, actualResult, 0);
    }
}
