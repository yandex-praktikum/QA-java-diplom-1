package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(float bunPrice, String bunName) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
    }

    @Parameterized.Parameters
    public static Object[][]  data(){
        return new Object[][]{
            {100, "black bun"},
            {200, "white bun"},
            {300, "red bun"},
            {100, ""},
            {200, "White bun"},
            {30.0f, " red bun"},
            {-100, "black bun"},
            {0, "whitebun"},
            {1, "white bun"},
            {400, "!@#$%^&*()_+"},
            {-1, "white bun"},
        };
    }

    @Test
    public void getNameTest(){
        Bun bun = new Bun(bunName, bunPrice);
        float expected = bunPrice;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(bunName, bunPrice);
        String expected = bun.name;
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }
}
