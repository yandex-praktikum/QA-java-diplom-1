package praktikum;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

public class BunTest {

    Bun bun;

    @Before
    public void setBun (){
        bun = new Bun("testBun", 25.0f);
    }

    @Test
    public void getNameTest(){
        String name = bun.getName();
        assertEquals("testBun", name);
    }

    @Test
    public void getPriceTest(){
        float price = bun.getPrice();
        assertEquals(25.0f, price);
    }
}