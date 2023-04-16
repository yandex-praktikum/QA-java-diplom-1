import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

@RunWith(Parameterized.class)
public class DatabaseBunParametrizedTest {
    Database base = new Database();
    private final int index;
    private final String name;
    private final int price;
    public DatabaseBunParametrizedTest(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300}
        };
    }
    @Test
    public void availableBunsTest() {
        Bun bun = base.availableBuns().get(index);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(), 0.0);
    }
}
