package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Onion", 1);

    @Test
    public void getIngredientPriceTest() {
        assertEquals(1, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getIngredientNameTest() {
        assertEquals("Onion", ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
