import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngredientParameterization extends BaseTestIngredient {
    private final IngredientType ingredientType;

    Ingredient createIngredient() {
        return new Ingredient(ingredientType, name, price);
    }

    public TestIngredientParameterization(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void checkIngredientGetIngredientType() {
        Assert.assertEquals(ingredientType, createIngredient().getType());
    }
}
