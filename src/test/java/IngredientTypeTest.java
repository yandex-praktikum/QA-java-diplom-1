import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    IngredientType ingredientType;
    String ingredientName;

    public IngredientTypeTest(IngredientType ingredientType, String ingredientName) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
    }

    @Parameterized.Parameters
    public static Object[][] allIngredientTypes() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    /**
     * Проверка наличия в перечислении конкретных элементов
     */
    @Test
    public void ingredientTypeInEnumTest() {
        Assert.assertEquals(ingredientType.toString(), ingredientName);
    }
}
