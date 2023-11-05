import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Mock
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100.0f);

    @Test
    public void testGetName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100.0f, ingredient.getPrice(), 0.001);
    }
    @Test
    public void testGetType(){
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}

