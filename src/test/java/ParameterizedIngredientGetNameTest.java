import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final IngredientType type = IngredientType.SAUCE;
    private final String name = "hot sauce";
    private final float price = 100;
    @Test
    public void getPriceReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(type, name, price);

        IngredientType actual = ingredient.getType();

        assertEquals("Returns incorrect ingredient type", type, actual);
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(type, name, price);

        String actual = ingredient.getName();

        assertEquals("Returns incorrect name", name, actual);
    }

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);

        float actual = ingredient.getPrice();

        assertEquals("Returns incorrect price", price, actual, 0);
    }
}
