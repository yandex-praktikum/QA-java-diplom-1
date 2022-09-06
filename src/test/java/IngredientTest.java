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
        IngredientType expected = type;

        IngredientType actual = ingredient.getType();

        assertEquals("Returns incorrect ingredient type", expected, actual);
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = name;

        String actual = ingredient.getName();

        assertEquals("Returns incorrect name", expected, actual);
    }

    @Test
    public void getPricaReturnsPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = price;

        float actual = ingredient.getPrice();

        assertEquals("Returns incorrect price", expected, actual, 0);
    }
}
