package praktikum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient;
    @Before
    public void setUP() {
        ingredient = new Ingredient(SAUCE, "hot sauce", 100);
    }

    @Test
    public void getPrice() {
        assertEquals(100, 100, ingredient.getPrice());
    }


    @Test
    public void getName() {
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals(SAUCE, ingredient.getType());
    }
}


