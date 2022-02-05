package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTests {

    @Test
    public void bunCanHaveNameTest(){
        Bun bun = new Bun("Planet", 120f);
        assertEquals("Planet", bun.getName());
    }

    @Test
    public void bunCanHavePriceTest(){
        Bun bun = new Bun("Planet", 120f);
        assertEquals(120f, bun.getPrice(), 0);
    }
}
