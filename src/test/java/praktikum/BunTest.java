package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    private final String expectedName = "Булочка";
    private final float expectedPrice = 10.0F;
    Bun bun = new Bun (expectedName, expectedPrice);

    @Test
    public void testGetName (){
        String actualName = bun.getName();
        Assert.assertEquals("Name is incorrect", expectedName, actualName);
    }

    @Test
    public void testGetPrice(){
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Price is incorrect", expectedPrice, actualPrice, 0);
    }

}