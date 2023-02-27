package praktikum.tests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class BunTest {
    // Create some bun
    Bun bun = new Bun("white bun", 200);

    @Test
    @Description("(Check method getName returns name")
    public void checkGetNameReturnsName() {
        Assert.assertEquals("The method getName returns bun's name","white bun", bun.getName());
    }

    @Test
    @Description("(Check method getPrice returns price")
    public void checkGetNameReturnsPrice() {
        Assert.assertEquals("The method getPrice returns bun's price",200, bun.getPrice(),0);

    }

}
