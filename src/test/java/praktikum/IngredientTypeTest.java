package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {


    private final IngredientType ingredientType;
    private final Ingredient ingredient;

    public IngredientTypeTest(Ingredient ingredient,
                              IngredientType ingredientType) {
        this.ingredient = ingredient;
        this.ingredientType = ingredientType;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {new Ingredient(SAUCE, "barbecue", 111), SAUCE},
                {new Ingredient(FILLING, "meat", 222), FILLING},
                {new Ingredient(SAUCE, "cheese", 333), SAUCE},
                {new Ingredient(FILLING, "fish", 444), FILLING}
        };
    }

    @Test
    public void getTypeTest() {
        assertEquals("Type is correct", ingredientType, ingredient.getType());
    }
}