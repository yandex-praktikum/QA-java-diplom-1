package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public IngredientParamTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус", 0.5f},
                {IngredientType.FILLING, "Котлета", 2.8f}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        float actual = ingredient.getPrice();
        assertEquals(ingredientPrice, actual, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        String actual = ingredient.getName();
        assertEquals(ingredientName, actual);
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        IngredientType actual = ingredient.getType();
        assertEquals(ingredientType, actual);
    }
}