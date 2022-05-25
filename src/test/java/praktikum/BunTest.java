package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Crater bun", 1255);
    }

    @Test
    public void getNameBunTest() {
        Assert.assertEquals("Булочка должна называться - Crater bun", "Crater bun", bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Assert.assertEquals("Цена булочки должна быть - 1255", 1255, bun.getPrice(), 0);
    }
}