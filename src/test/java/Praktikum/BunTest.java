package Praktikum;


import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("Краторная булка N-200i", 1255);
    @Test
    public void checkGetName(){
        String actualName = bun.getName();
        String expectedName = "Краторная булка N-200i";
        assertEquals ("Ожидается: Краторная булка N-200i", expectedName,actualName);
    }

    @Test
    public void checkGetPrice(){
        float actualPrice = bun.getPrice();
        float expectedPrice = 1255;
        assertEquals ("Ожидается: 1255", expectedPrice,actualPrice,0);
    }
}
