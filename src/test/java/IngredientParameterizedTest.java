import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {
    private final IngredientType initialType;

    public IngredientParameterizedTest(IngredientType initialType) {
        this.initialType = initialType;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(initialType, "name", 0.0f);

        IngredientType actual = ingredient.getType();

        Assert.assertEquals("Wrong ingredient type", actual, initialType);
    }
}
