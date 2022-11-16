import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters
    public static Object[][] ingredientTypeData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }
    private final IngredientType actual;
    private final String expected;

    public IngredientTypeTest(IngredientType actual, String expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Test
    public void ingredientTypeTest() {
        assertEquals(IngredientType.valueOf(expected), actual);
    }
}
