import org.junit.Test;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String NAME_OF_THE_BUN = "Name";
    private final float PRICE_OF_THE_BUN = 10;
    private Bun bun = new Bun(NAME_OF_THE_BUN, PRICE_OF_THE_BUN);

    @Test
    public void testBunGetNameMethod(){
        assertEquals("Check name",NAME_OF_THE_BUN, bun.getName());
    }
    @Test
    public void testBunGetPriceMethod(){
        assertEquals("Check price", PRICE_OF_THE_BUN,bun.getPrice(),0);
    }
}
