import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class BunTest {
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private float price;
    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][]{
                {"black bun", 100f},
                {"", 200f},
                {"LongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLongLong", 300f},
                {null, 200f},
                {"black bun", -100f},
                {"black bun", 0.0001f},
                {"black bun", 0},
        };
        return Arrays.asList(data);
    }
    @Test
    public void getNameReturnCorrectValue() {
        Bun bun = new Bun(name, price);
        String expectedName= name;
        String actualName = bun.getName();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test
    public void getPriceReturnCorrectValue() {
        Bun bun = new Bun(name, price);
        float expectedPrice= price;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice,actualPrice,0.001);
    }

}
