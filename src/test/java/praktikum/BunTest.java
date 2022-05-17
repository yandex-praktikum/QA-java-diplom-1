package praktikum;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    Bun bun;
    final String expectedName = "Ржаная булочка";
    final float expectedPrice = 140;

    @Before
    public void setUp(){
       bun = new Bun(expectedName,expectedPrice);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        String actualName = bun.getName();
        assertEquals(expectedName,actualName);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice,actualPrice,0);
    }
}