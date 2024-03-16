import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

public class BunTest {
    float fluBunPrice = 1.50f;
    float kratorsBunPrice = 2.10f;
    @Test
    public void testGetName() {
        Bun bun = new Bun("FluBun", fluBunPrice);
        assertEquals("FluBun", bun.getName());
    }

    @Test
    public void testGetPrice(){
        Bun bun = new Bun("KratorsBun", kratorsBunPrice);
        assertEquals(kratorsBunPrice, bun.getPrice());
    }


}
