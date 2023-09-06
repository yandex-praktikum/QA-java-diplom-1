package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private final String testName = "Бургер";
    private final float testPrice = 10;
    Bun bun = new Bun(testName,testPrice);
@Test
public void testGetName(){
    String expected = "Бургер";
    String actual = bun.getName();
    Assert.assertEquals(expected,actual);
}
    @Test
    public void testGetPrice(){
        float expected = 10;
        float actual = bun.getPrice();
        Assert.assertEquals(expected,actual,0);
    }


}