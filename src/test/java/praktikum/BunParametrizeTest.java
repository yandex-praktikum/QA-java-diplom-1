package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParametrizeTest {

    Bun bun;
    private String bunName;
    private float bunPrice;

    public BunParametrizeTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Тест", 10.0f},
                {"", 0},
                {null, 100.5f},
                {"123", -10f},
                {"Тест", 10.25f}
        };
    }



    @Test
    public void getNameExpectedEqualsActual(){
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceExpectedEqualsActual(){
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
