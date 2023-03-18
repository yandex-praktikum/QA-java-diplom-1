import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    IngredientType ingredientType;
    Ingredient ingredient;
    String name;
    float price;

    @Before
    public void setUp() {
        name = "Майонез";
        ingredientType = IngredientType.SAUCE;
        price = 12.15f;
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void whenCallGetPriceThenReturnFloatTest() {
        float expected = price;

        float actual = ingredient.getPrice();

        assertEquals(expected, actual, 0);
    }

    @Test
    public void whenCallGetNameThenReturnStringTest() {
        String expected = name;

        String actual = ingredient.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void whenCallGetTypeThenReturnIngredientTypeTest() {
        IngredientType expected = ingredientType;

        IngredientType actual = ingredient.getType();

        assertEquals(expected, actual);
    }
}
