package praktikum;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    static Bun bun;

    @BeforeClass
    public static void createBun() {
        bun = new Bun("Moskovskaya", 25);
    }

    @Test
    public void getName() {
        String expectedName = "Moskovskaya";
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        float expectedPrice = 25;
        assertEquals(expectedPrice, bun.getPrice(), 0.0);
    }
}