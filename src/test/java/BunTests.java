import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTests {
    private final String NAME_EXPECTED;
    private final float PRICE_EXPECTED;

    public BunTests(String name, float price){
        this.NAME_EXPECTED = name;
        this.PRICE_EXPECTED = price;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"", 0},
                {"&^$&#*", 19231},
                {"nameO", -4342},
                {"323", Float.MIN_VALUE},
                {"nameOfBun", Float.MAX_VALUE}
        };
    }

    @Test
    public void getBunNameTest(){
        Bun bun = new Bun(NAME_EXPECTED, PRICE_EXPECTED);
        Assert.assertEquals(NAME_EXPECTED, bun.getName());
    }

    @Test
    public void getBunPriceTest(){
        Bun bun = new Bun(NAME_EXPECTED, PRICE_EXPECTED);
        Assert.assertEquals(PRICE_EXPECTED, bun.getPrice(), 0);
    }
}