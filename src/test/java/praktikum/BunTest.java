package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    @Test
    public void bunCreationTest() {
        // given
        String name = "sesame";
        float price = 1.2f;

        // when
        Bun bun = new Bun(name, price);

        // then
        assertEquals(name, bun.getName());
        assertEquals(price, bun.getPrice(), 0);
    }
}