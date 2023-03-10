package praktikum;


import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private final static String SAUCE_NAME = "barbecue";
    private final static String INGREDIENT_NAME = "meat";
    private final static float PRICE = new Random().nextFloat();

    @Mock
    IngredientType ingredientType;

    @Test
    public void getIngredientNameTest() {
        Ingredient ingredient = new Ingredient(SAUCE, SAUCE_NAME, PRICE);
        assertEquals("Name is correct", SAUCE_NAME, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, SAUCE_NAME, PRICE);
        assertEquals("Price is correct", PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, INGREDIENT_NAME, PRICE);
        assertEquals("Type is correct", ingredientType, ingredient.getType());
    }
}
