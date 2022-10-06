package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("Тест", 1.0F);
    @Test
    public void getName() {
        assertEquals("Тест",bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(1.0F,bun.getPrice(),0);
    }
}