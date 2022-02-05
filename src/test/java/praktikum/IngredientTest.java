package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    IngredientType type = IngredientType.SAUCE;
    String name = "cutlet";
    float price = 100;

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = 100;
        assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = "cutlet";
        assertEquals(expected, ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredientSauce = new Ingredient(type, name, price);
        assertEquals(IngredientType.SAUCE, ingredientSauce.getType());
    }
}