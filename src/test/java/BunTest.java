import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"black bun", 100.0f},
                {"white bun", 200.0f},
                {"red bun", 300.0f},
        });
    }
    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        String actualName = bun.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        float actualPrice = bun.getPrice();
        Assert.assertEquals(actualPrice, price, TestConstants.delta);
    }
}

