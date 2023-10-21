package praktikum;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
        String actual = bun.getName();
        assertEquals(WRONG_NAME_MSG, BLACK_BUN,actual);
    }

    @Test
    public  void getPricePositiveTest(){
        float actual  = bun.getPrice();
        assertEquals(WRONG_PRICE_MSG, BLACK_PRICE, actual,DELTA);
    }

    @Test
    public void getNameNegativeTest (){
        String actual = bun.getName();
        assertNotEquals(FAKE_EQUAL_NAME_MSG, FAKE_NAME,actual);
    }
    @Test
    public void getPriceNegativeTest(){
        float actual = bun.getPrice();
        assertNotEquals(FAKE_EQUAL_PRICE_MSG, FAKE_PRICE,actual);
    }

}
