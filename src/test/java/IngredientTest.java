import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    @Mock
    private IngredientType ingredientType;

    @Before
    public void setup() {
        ingredient = new Ingredient(ingredientType, "TestIngredient", 123.453f);
    }

    @Test
    public void testGetPrice() {
        float actual = ingredient.getPrice();
        float expected = 123.453f;
        assertEquals(expected, actual, 1e-15);
    }

    @Test
    public void testGetName() {
        String actual = ingredient.getName();
        String expected = "TestIngredient";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetType() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredient.type;
        assertEquals(expected, actual);
    }
}
