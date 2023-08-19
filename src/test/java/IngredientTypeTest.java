import praktikum.IngredientType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String ingredientType;

    public IngredientTypeTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Название типа ингредиента : {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeContainsRightType() {
        Assert.assertEquals("Такого ингредиента нет", ingredientType, IngredientType.valueOf(ingredientType).toString());
    }
}