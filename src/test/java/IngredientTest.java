import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private final IngredientType type = IngredientType.SAUCE;
    private final String name = "Кетчуп";
    private final float price = 1.25f;
    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceReturnCorrectValue() {
        assertEquals(ingredient.getPrice(), price, 0);
    }

    @Test
    public void getNameReturnCorrectValue() {
        assertEquals(ingredient.getName(), name);
    }

    @Test
    public void getTypeReturnCorrectValue() {
        assertEquals(ingredient.getType(), type);
    }

}
