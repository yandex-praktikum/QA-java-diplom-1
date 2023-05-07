import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Test Bun", 2.0f);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Test Bun";
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 2.0f;
        assertEquals(expectedPrice, bun.getPrice(), 0.01);
    }

}