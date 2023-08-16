package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedIngredientTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;

    public ParameterizedIngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { IngredientType.SAUCE, "Test Sauce", 25 },
                { IngredientType.FILLING, "Test Filling", 30 },
        });
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertEquals(ingredientType, ingredient.getType());
    }
}