import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private String name = "test sauce";
    private float price = 100;

    @Mock
    Ingredient ingredient;
    IngredientType ingredientType;

    @Before
    public void setup() {
        ingredient = new Ingredient(ingredientType.SAUCE, name, price);
    }

    @Test
    public void checkPrice() {
        float actual = ingredient.getPrice();
        float expected = 100;

        assertEquals(expected, actual, 0);
    }

    @Test
    public void checkName() {
        String actual = ingredient.getName();
        String expected = "test sauce";

        assertEquals(expected, actual);
    }

    @Test
    public void checkType() {
        String actual = String.valueOf(ingredient.getType());
        String expected = "SAUCE";

        assertEquals(expected, actual);
    }
}
