import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {
    Bun bun;
    @Before
    public void initBun() {
        bun = new Bun("Название_булочки", 1);
    }
    @Test
    public void checkGetName() {
        String expectedName = "Название_булочки";
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = 1;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
