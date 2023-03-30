import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;


@RunWith(Parameterized.class)
public class DatabaseBunsTest {

    private final int index;
    private final String name;
    private final int price;

    public DatabaseBunsTest(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, "black bun", 100},
                {1,"white bun", 200},
                {2,"red bun", 300}
        };
    }

    @Test
    public void availableBunsReturnCorrectList() {
        Database database = new Database();
        Assert.assertEquals(name, database.availableBuns().get(index).getName());
        Assert.assertEquals(price, database.availableBuns().get(index).getPrice(), 0);
    }
}
