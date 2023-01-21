package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;
    private String bunName = "hello";
    private float bunPrice = 123.00F;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0.0);
    }
}