package praktikum_tests;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;


public class ClassBunTest {
    // Create some bun
    Bun bun = new Bun("white bun", 200);

    @Test
    @Description("(Check method getName returns name")
    public void checkGetNameReturnsName() {
        Assert.assertEquals("white bun", bun.getName());
    }

    @Test
    @Description("(Check method getPrice returns price")
    public void checkGetNameReturnsPrice() {
        Assert.assertEquals(200, bun.getPrice(),0);

    }





}
