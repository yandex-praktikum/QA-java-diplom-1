import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setup() {
        bun = new Bun("Булочка", 10);
    }

    @Test
    public void getNameTest() {
        String expectedName = "Булочка";
        String actualName = bun.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 10;
        float actualPrice = bun.getPrice();

        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}


