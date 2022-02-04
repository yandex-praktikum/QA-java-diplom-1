import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final Bun bun = new Bun("black bun", 1000);

    @Test
    public void getName() {
        assertEquals(bun.getName(), "black bun");
    }

    @Test
    public void getPrice() {
        assertEquals(1000.000, bun.getPrice(), 0);
    }
}
