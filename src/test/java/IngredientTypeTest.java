import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expIngredientType;

    public IngredientTypeTest(String expIngredientType) {
        this.expIngredientType = expIngredientType;
    }

    @Parameterized.Parameters(name = "{0},{1}")
    public static Object[][] testData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Assert.assertEquals(expIngredientType, IngredientType.valueOf(expIngredientType).toString());
    }

}
