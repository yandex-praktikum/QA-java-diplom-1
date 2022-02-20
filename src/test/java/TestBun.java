import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {
    final String BUN_NAME = "Test";
    final Float BUN_PRISE = 5.5f;
    private Bun bun;

    @Before
    public void before(){
        bun = new Bun(BUN_NAME, BUN_PRISE);
    }

    @Test
    public void getNameBun(){
        String resultGetName = bun.getName();
        assertEquals(BUN_NAME, resultGetName);
    }

    @Test
    public void getPriceBun(){
        Float resultGetPrice = bun.getPrice();
        assertEquals(BUN_PRISE, resultGetPrice);
    }

}
