package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Краторная булка N-200i", 1255);
    @Test
    public void checkGetName(){
        String actualName = bun.getName();
        String expectedName = "Краторная булка N-200i";
        assertEquals (expectedName,actualName);
    }

    @Test
    public void checkGetPrice(){
        float actualPrice = bun.getPrice();
        float expectedPrice = 1255;
        assertEquals (expectedPrice,actualPrice,0);
    }
}
