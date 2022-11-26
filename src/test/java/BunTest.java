import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }
    public Bun bun;
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"sweet bun", 200.45f},
                {"delicious bun", 145.0f},
                {"yeast-free bun", 137}
        };
    }

    @Before
    public void init(){
        bun = new Bun(name, price);
    }

    @Test
    public void bunGetNameTest(){
        String nameExpected = this.name;
        Assert.assertEquals(nameExpected, bun.getName());
    }

    @Test
    public void bunGetPriceTest(){
        float priceExpected = this.price;
        Assert.assertEquals(priceExpected, bun.getPrice(), 0.00001);
    }
}
