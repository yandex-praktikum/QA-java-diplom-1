import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    @Test
    public void testGetNameReturnName() {
        String name = "Булка";
        Ingredient ingredient = new Ingredient(SAUCE, "Булка", 12.3F);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPriceReturnPrice() {
        float price = 12.3F;
        Ingredient ingredient = new Ingredient(FILLING, "Булка", price);
        assertEquals(price, ingredient.getPrice(), 0);
    }


}

