import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final Ingredient ingredient;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    public IngredientParametrizedTest(Ingredient ingredient, IngredientType expectedType, String expectedName, float expectedPrise) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrise;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {new Ingredient(SAUCE, "hot sauce", 100f), SAUCE, "hot sauce", 100f},
                {new Ingredient(SAUCE, " Горячий соус", 0), SAUCE, " Горячий соус", 0},
                {new Ingredient(SAUCE, "Сырный соус ", 100.5f), SAUCE, "Сырный соус ", 100.5f},
                {new Ingredient(SAUCE, " Кирияки соус ", -100.5f), SAUCE, " Кирияки соус ", -100.5f},
                {new Ingredient(SAUCE, "sour cream", 200f), SAUCE, "sour cream", 200f},
                {new Ingredient(FILLING, " dinosaur", 200f), FILLING, " dinosaur", 200f},
                {new Ingredient(FILLING, "cutlet ", 200.5f), FILLING, "cutlet ", 200.5f},
                {new Ingredient(FILLING, " sausage ", 0), FILLING, " sausage ", 0},
                {new Ingredient(FILLING, " бекон", -200.5f), FILLING, " бекон", -200.5f},
                {new Ingredient(FILLING, "помидоры ", 100), FILLING, "помидоры ", 100},
                {new Ingredient(FILLING, " соленые огурчики ", 0), FILLING, " соленые огурчики ", 0}
        };
    }
    @Test
    public void ingredientTest() {
        Assert.assertEquals(expectedType, ingredient.getType());
        Assert.assertEquals(expectedName, ingredient.getName());
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 0.0f);
    }
}