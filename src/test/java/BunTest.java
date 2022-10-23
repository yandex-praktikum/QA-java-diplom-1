import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Database;

public class BunTest {
    @Mock
    Bun bun;
    String actualName = "black bun";
    float actualPrice = 100;
    Database database;

    @Before
    public void setUp() {
        database = new Database();
        bun = new Bun(actualName, actualPrice);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(database.availableBuns().get(0).name, actualName);
    }

    @Test
    public void testGetPrice() {
        Assert.assertEquals(database.availableBuns().get(0).price, actualPrice, 0.0f);
    }
}
