package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameBunOneTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void getPriceBunOneTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988);
        assertEquals(988.0, bun.getPrice(), 0);
    }

    @Test
    public void getNameBunTwoTest() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        assertEquals("Краторная булка N-200i", bun.getName());
    }

    @Test
    public void getPriceBunTwoTest() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        assertEquals(1255.0, bun.getPrice(), 0);
    }
}
