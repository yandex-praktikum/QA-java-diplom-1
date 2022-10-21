import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientsTest {
    private IngredientType ingredientType;
    private String name;
    private float price;
    private IngredientType expected1;
    private String expected2;
    private float expected3;

    public IngredientsTest(IngredientType ingredientType, String name, float price, IngredientType expected1, String expected2, float expected3) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.expected1 = expected1;
        this.expected2 = expected2;
        this.expected3 = expected3;
    }

    @Parameterized.Parameters
    public static Object[][] parameterizedTest() {
        return new Object[][] {
                {IngredientType.SAUCE, "Начинка 1", 200.0f, IngredientType.SAUCE, "Начинка 1", 200.0f},
                {IngredientType.FILLING, "Начинка 2", 311.0f, IngredientType.FILLING, "Начинка 2", 311.0f},
                {IngredientType.SAUCE, "Начинка 3", 100.0f, IngredientType.SAUCE, "Начинка 3", 100.0f},
        };
    }

    @Test
    public void getTypeReturnsTypeOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expected1, ingredient.getType());
    }

    @Test
    public void getNameReturnsNameOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expected2, ingredient.getName());
    }

    @Test
    public void getPriceReturnsPriceOfIngredient() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(expected3, ingredient.getPrice(), 0);
    }
}
