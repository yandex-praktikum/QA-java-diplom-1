import org.junit.jupiter.api.Test;
import praktikum.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class CheckIngredientTest {
    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "test", 1000);
        assertEquals(1000, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "test", 1000);
        assertEquals("test", ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "test", 1000);
        assertEquals(SAUCE, ingredient.getType());
    }

}
