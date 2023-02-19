package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunBizarreDataParamTest {

    private final String actualName;
    private final String expectedName;
    private final float actualPrice;
    private final float expectedPrice;

    public BunBizarreDataParamTest(String actualName, String expectedName, float actualPrice, float expectedPrice) {
        this.actualName = actualName;
        this.expectedName = expectedName;
        this.actualPrice = actualPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] createBunParams() {
        return new Object[][] {
                {null, null, 0f, 0f},
                {"", "", 100.25f, 100.25f},
                {"#345!", "#345!", -10.14f, -10.14f},
        };
    }

    private  Bun actualBun;

    @Before
    public void setup() {
        actualBun = new Bun(actualName, actualPrice);
    }

    @Test
    public void testGetNameWithParams() {
        assertEquals(expectedName, actualBun.getName());
    }

    @Test
    public void testGetPriceWithParams() {
        assertEquals(expectedPrice, actualBun.getPrice(), 0);
    }

}
