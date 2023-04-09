import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientGetTypeParameterizedTest {
    private Ingredient ingredient;
    private String ingredientName = "tastyOnion";
    private float ingredientPrice = 18.52f;
    private IngredientType type;

    public IngredientGetTypeParameterizedTest(IngredientType type) {
    this.type = type;
    }

    @Parameterized.Parameters(name = "Ingredient type: {0}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING},
        };
    }

    @Test
    public void getTypeShouldReturnType() {
        ingredient = new Ingredient(type, ingredientName, ingredientPrice);
        assertEquals(type, ingredient.getType());
    }
}
