import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


public class BunTest {
    @Test
    public void returnBunNameTest(){
        Bun bun =new Bun("delicious", 0.77f);
        assertEquals("delicious", bun.getName());
    }

    @Test
    public void returnBunPriceTest(){
        Bun bun =new Bun("delicious", 0.77f);
        assertEquals(0.77f, bun.getPrice(),0);
    }
}
