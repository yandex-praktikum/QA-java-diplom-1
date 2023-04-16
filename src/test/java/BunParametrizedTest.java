import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParametrizedTest {
    Bun bun;
    private final String expectedName;
    private final float expectedPrice;
    public BunParametrizedTest(Bun bun, String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Bun("black bun", 100f), "black bun", 100f},
                {new Bun("white bun", 200f), "white bun", 200f},
                {new Bun("red bun", 300f), "red bun", 300f},
                {new Bun("булочка", 10f), "булочка", 10f},
                {new Bun(" булочка", 10.10f), " булочка", 10.10f},
                {new Bun("булочка ", 0), "булочка ", 0},
                {new Bun("@bun@", -1), "@bun@", -1},
                {new Bun(" bun ", -10.10f), " bun ", -10.10f},

        };
    }
    @Test
    public void bunTest(){
        Assert.assertEquals(expectedName, bun.getName());
        Assert.assertEquals(expectedPrice, bun.getPrice(),0.0);
    }
}