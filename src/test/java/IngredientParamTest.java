import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    @Mock
    static
    IngredientType ingredientType;

    private final IngredientType type;
    private final IngredientType expectedType;

    public IngredientParamTest(IngredientType type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {ingredientType.FILLING, ingredientType.FILLING},
                {ingredientType.SAUCE, ingredientType.SAUCE},
        };
    }

    @Test
    public void getTypeReturnsTypeParamTest() {
        Ingredient ingredient = new Ingredient(type, null, 0);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
