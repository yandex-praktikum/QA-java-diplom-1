package praktikum;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static praktikum.Constant.*;
import static praktikum.Message.*;


public class BunTest {
    private Bun bun;

    @Before
    public  void newBun(){
        bun = new Bun(BLACK_BUN, BLACK_PRICE);
    }

    @Test
    public void getNamePositiveTest(){
        assertEquals(WRONG_NAME_MSG, BLACK_BUN,bun.getName());
    }

    @Test
    public  void getPricePositiveTest(){
        assertEquals(WRONG_PRICE_MSG, BLACK_PRICE, bun.getPrice(),DELTA);
    }

    @Test
    public void getPriceNegativeTest(){
        assertThrows(Exception.class, () -> bun.getPrice(FAKE_NAME));
    }

}
