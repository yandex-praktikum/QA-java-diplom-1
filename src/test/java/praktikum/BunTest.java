package praktikum;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameAndPriceTest(){
        Bun bun = new Bun("Булочка", (float) 1.21);
        String expectedName = "Булочка";
        float expectedPrice = (float) 1.21;
        String actualName = bun.getName();
        float actualPrice = bun.getPrice();
        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice,actualPrice,0.0f);
    }

}