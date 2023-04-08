package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    String expectedName;
    float expectedPrice;

    public BunTest(Bun bun, String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Bun("black", 15), "black", 15},
                {new Bun("red", -1), "red", 0},
                {new Bun("white", 1000.1f), "white",0},
                {new Bun("ok", 150), null,150},
                {new Bun("blackblack", 0.1f), "blackblack", 0.1f},
                {new Bun(" red", 1000), null, 1000},
                {new Bun("red ", 0), null, 0},
                {new Bun("White", 999), "White", 999},
                {new Bun("Good evening", 20), null, 20},

        };
    }
    @Test
    public void bunTest(){
        Assert.assertEquals(expectedName,bun.getName());
        Assert.assertEquals(expectedPrice,bun.getPrice(),0.0);
    }
}