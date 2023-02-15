
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    Bun bun;
    private String nameBun;
    private float priceBun;
    private final String actualName = "black bun";
    private final String actualName2 = "white bun";
    private final String actualName1 = "red bun";
    private final float actualPrice = 100.0F;
    private final float actualPrice1 = 200.0F;
    private final float actualPrice2 = 300.0F;

    public BunTest(String nameBun, float priceBun) {
        this.priceBun = priceBun;
        this.nameBun = nameBun;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{{"aaa", 99}, {"ddd", 100}};
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(this.nameBun, this.priceBun);
        String expected = this.nameBun;
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(this.nameBun, this.priceBun);
        float expected = this.priceBun;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0.0F);
    }
}

