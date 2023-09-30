package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String name = "Флюоресцентная булка R2-D3";
    private float price = 9.88f;

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void testGetName() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, bun.getPrice(), 0.01);
    }
}
