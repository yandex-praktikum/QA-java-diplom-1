import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.*;


public class NegativeTestBun {
    @Test
    public void testGetNameNull() {
        Bun bun = new Bun(null, 1.50f);
        assertNull(bun.getName());
    }
    @Test
    public void testGetPriceNegative() {
        Bun bun = new Bun("Bun", -10.0f);
        assertTrue(bun.getPrice() < 0);
    }
    @Test
    public void testSetNameNull() {
        Bun bun = new Bun("Bun", 10.0f);
        bun.setName(null);
        assertEquals(null, bun.getName());
    }

    //проверяем, что метод не устанавливает отрицательную цену булочки
    @Test
    public void testSetPriceNegative() {
        Bun bun = new Bun("Bun", 10.0f);
        bun.setPrice(-20.0f);
        assertFalse(bun.getPrice() > 0);
    }
}


