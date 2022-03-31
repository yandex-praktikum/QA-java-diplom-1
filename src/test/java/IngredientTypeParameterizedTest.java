import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {


    private final IngredientType actualIngredient;
    private final String expectedIngredient;

    public IngredientTypeParameterizedTest(IngredientType actual, String expected) {
        this.actualIngredient = actual;
        this.expectedIngredient = expected;
    }

    @Parameterized.Parameters
    public static Object[][] CheckIngredientType() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        Assert.assertEquals(expectedIngredient, actualIngredient.toString());
    }
}




