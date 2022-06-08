import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void bunNameTest() {
        Database database = new Database();
        Bun bun = database.availableBuns().get(0);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void bunPriceTest() {
        Database database = new Database();
        Bun bun = database.availableBuns().get(2);
        assertEquals(300, bun.getPrice(), 0);
    }
}
