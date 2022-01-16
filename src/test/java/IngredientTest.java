import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {


    @Mock
    IngredientType type;
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Мясо", 4.2F);

    @Test
    public void getIngredientTypeTest() {
        assertEquals(ingredient.getType(), type.FILLING);
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals(ingredient.getName(), "Мясо");
    }

    @Test
    public void getIngredientPriceTest() {
        assertEquals(ingredient.getPrice(), 4.2F, 0);
    }
}
