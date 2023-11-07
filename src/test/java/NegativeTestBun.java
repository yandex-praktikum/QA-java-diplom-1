import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.*;


public class NegativeTestBun {
    @Test
    public void testGetNameNull() {
       Bun bun = new Bun(null, 1);
        assertNull(bun.getName());
    }
    @Test
    public void testGetPriceNegative() {
        Bun bun = new Bun("Bun", -10);
        assertTrue(bun.getPrice() < 0);
    }
    @Test
    public void testSetNameNull() {
        Bun bun = new Bun("Bun", 10);
        bun.setName(null);
        assertEquals(null, bun.getName());
    }
    @Test
    public void testSetPriceNegative() {
        Bun bun = new Bun("Bun", 10);
        bun.setPrice(-20);
        assertFalse(bun.getPrice() > 0);
    }
}


