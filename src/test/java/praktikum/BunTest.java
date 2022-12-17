package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest extends BaseTestData {

    Bun bun = new Bun(testBunName, testBunPrice);
    @Test
    public void getName() {
        assertEquals(testBunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(testBunPrice, bun.getPrice(), 0);
    }
}