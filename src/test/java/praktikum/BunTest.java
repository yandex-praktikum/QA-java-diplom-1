package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun;

    @Test
    public void testGetBunName() {
        bun = new Bun("black bun", 100.0F);
        assertEquals("black bun", bun.getName());

    }

    @Test (expected = Exception.class)
    public void testGetBunNameIsNull() throws Exception {
        bun = new Bun(null, 100.F);
        bun.getName();
    }

    @Test (expected = Exception.class)
    public void testGetBunNameIsBlank() throws Exception {
        bun = new Bun("", 100.F);
        bun.getName();
    }

    @Test
    public void testGetBunPriceFloatPositive() {
        bun = new Bun("black bun", 100.0F);
        assertEquals(100.0F, bun.getPrice(),0);
    }

    @Test
    public void testGetBunPriceIntPositive() {
        bun = new Bun("black bun", 100);
        assertEquals(100, bun.getPrice(),0);
    }
    @Test (expected = Exception.class)
    public void testGetBunPriceIsNegative() throws Exception {
        bun = new Bun("black bun", -0.01F);
        bun.getPrice();
    }

}