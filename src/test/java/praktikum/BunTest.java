package praktikum;

import org.junit.Test;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;


public class BunTest {

    private String name = "Классическая";
    private float price = 1569.50F;

    Bun bun = new Bun(name, price);

    @Test
    public void testGetNameBun(){
        String expected = bun.getName();
        assertEquals("Имя булки не возвращается", expected, name);
    }

    @Test
    public void testGetPriceBun(){
        float expected = bun.getPrice();
        assertEquals("Цена булки не возвращается", expected, price, 0);
    }


}
