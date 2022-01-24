import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun = new Bun("Имя", 2.3F);

    @Test
    public void getBunNameTest() {
        assertEquals(bun.getName(), "Имя");
    }

    @Test
    public void getBunPriceTest() {
        assertEquals(bun.getPrice(), 2.3F, 0);
    }

}
