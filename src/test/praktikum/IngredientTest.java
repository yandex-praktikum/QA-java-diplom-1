package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    Ingredient ingredient;
    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "cream", 25.35f);
    }
    @Test
    public void getPriceEqual() {
        assertEquals(25.35f,ingredient.getPrice(), 0);
    }
    @Test
    public void getNameEqual() {
        assertEquals("cream",ingredient.getName());
    }
    @Test
    public void getTypeEqual() {
        assertEquals(IngredientType.FILLING,ingredient.getType());
    }
}
