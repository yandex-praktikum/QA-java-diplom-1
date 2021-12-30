import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final int type;
    private final String expected;

    public IngredientTypeTest(int type, String expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {0, "SAUCE"},
                {1, "FILLING"},
        };
    }

    @Test
    public  void verifyIngredientTypeTest(){
        Assert.assertEquals(expected, IngredientType.values()[type].name());
    }
}
