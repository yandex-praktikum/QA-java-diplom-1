import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getType() {
        return new Object[][] {
                { IngredientType.SAUCE },
                { IngredientType.FILLING }
        };
    }

    @Test
    public void shouldGetIngredientType() {
        Ingredient ingredient = new Ingredient(ingredientType, "Тёмная материя", 1.0F);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }

}
