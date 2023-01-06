package ingredient;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "Бургер";
    private final float price = 325;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);

    @Test
    public void getPriceReturnPrice() {
        assertEquals("Бургер", ingredient.getName());
    }

    @Test
    public void getNameReturnName() {
        assertEquals(325, ingredient.getPrice(), 0.01);
    }
}
