import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {

    protected final static String INGREDIENT_TYPE_FILLING = "FILLING";
    protected final static String INGREDIENT_TYPE_SAUCE = "SAUCE";
    private final IngredientType ingredientType;
    private final String expectedIngredientName;

    public IngredientTypeParametrizedTest(IngredientType ingredientType, String expectedIngredientName) {
        this.ingredientType = ingredientType;
        this.expectedIngredientName = expectedIngredientName;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeData() {
        return new Object[][]{
                { IngredientType.FILLING, INGREDIENT_TYPE_FILLING},
                { IngredientType.SAUCE, INGREDIENT_TYPE_SAUCE }
        };
    }

    @Test
    public void checkIngredientTypeName(){
        Assert.assertEquals("Неверное наименование типа ингредиента!", IngredientType.valueOf(expectedIngredientName), ingredientType);
    }
}
