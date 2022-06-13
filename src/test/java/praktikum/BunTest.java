package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("Булка",10.0001F);
        String actual = bun.getName();
        String expected = "Булка" ;
        assertEquals(expected,actual) ;
    }

    @Test
    public void getPrice() {
            Bun bun = new Bun("Булка",10.0001F);
            float  actual = bun.getPrice();
            float  expected = 10.0001F;
            assertEquals(expected, actual, 0.0F);
    }

}