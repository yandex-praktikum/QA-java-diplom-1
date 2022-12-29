import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expectedIngredientType;

    public IngredientTypeTest(String expectedIngredientType) {
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals(expectedIngredientType, IngredientType.valueOf(expectedIngredientType).toString());
    }

}
