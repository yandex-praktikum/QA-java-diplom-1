package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static praktikum.DataForTests.*;


public class TestBun {
    private Bun bun;

    @Before
    public void setUp () {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }
    @Test
    public void testGetNameReturnBunName (){
        assertEquals(BUN_NAME, bun.getName());
    }
    @Test
    public void testGetNameReturnBunPrice (){
        assertEquals(BUN_PRICE, bun.getPrice(), 0f);
    }
}
