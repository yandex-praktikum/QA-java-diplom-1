package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void checkGetName() {
        Bun bun = new Bun("Железобетонная булочка", 393F);
        String actual = bun.getName();
        assertEquals("Железобетонная булочка", actual);
    }

    @Test
    public void checkGetPrice() {
        Bun bun = new Bun("Железобетонная булочка", 393F);
        float actual = bun.getPrice();
        assertEquals(393F, actual, 0F);
    }
}