import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun1;
    private static final String BUN_NAME = "Пирожок";
    private static final float BUN_PRICE = 18.44f;

    @Before
    public void setUp() {
        bun1 = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals(BUN_NAME, bun1.getName());
    }

    @Test
    public void getNamePrice() {
        assertEquals(BUN_PRICE, bun1.getPrice(), 0.0001);
    }

}
