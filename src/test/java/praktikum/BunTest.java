package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BunTest {

    private final Bun bun = new Bun("Краторная булка N-200i",1255);

    @Test
    public void getNameShouldReturnBunName(){
        String expectedResult = "Краторная булка N-200i";
        String actualResult = bun.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceShouldReturnBunPrice(){
        float expectedResult = 1255;
        float actualResult = bun.getPrice();

        assertEquals(expectedResult, actualResult,0);
    }

}
