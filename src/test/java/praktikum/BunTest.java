package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    public float price = 10.5F;
    private String name = "Testname";
    Bun bun = new Bun(name, price);

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, bun.getPrice(), 0.0);
    }
}
