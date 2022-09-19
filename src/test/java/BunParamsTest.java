import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)

public class BunParamsTest {
private String bunName;
private float bunPrice;


public BunParamsTest(String bunName, float bunPrice) {
    this.bunName = bunName;
    this.bunPrice = bunPrice;

}
    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][] {
                { "hot_bun", 180},
                { "Grand Bun", 99},
                { "булка года", 0},
        };
    }

    @Test
    public void createBunWithAnyParamsTest(){
       Bun bun = new Bun(bunName, bunPrice);
       float actualPrice = bun.getPrice();
        Assert.assertEquals(bunPrice, actualPrice, 0);
       String actualName = bun.getName();
       Assert.assertEquals(bunName, actualName);

        }

    }



