import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;


@RunWith(Parameterized.class)
public class DatabaseBunsParameterizedTest {

    private final Database database = new Database();
    private final String bunName;
    private final float bunPrice;

    public DatabaseBunsParameterizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
            {"black bun", 100},
            {"white bun", 200},
            {"red bun", 300}
        };
    }

    @Test
    public void availableIngredientsAvailableIngredientsChecked() throws Exception {
        int bunsTotalCount = 3;
        int count = 0;
        for (Bun bun : database.availableBuns()) {
            if (bun.name.equals(bunName)) {
                Assert.assertEquals("Bun price isn't correct", bun.getPrice(), bunPrice, 0.01f);
            } else {
                count++;
            }
            if (count == bunsTotalCount) {
                throw new Exception("Bun isn't available");
            }
        }
    }

}
