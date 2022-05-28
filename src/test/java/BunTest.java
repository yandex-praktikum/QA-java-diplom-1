import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;
    private final String expectedName = "Классическая булка";
    private final float expectedPrice = 70;

    @Before
    public void setUp(){
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void testGetName() {
        String actualName = bun.getName();
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedName, actualName);

    }
    @Test
    public void testGetPrice() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", expectedPrice, actualPrice,1);
    }
}
