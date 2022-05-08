package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;
    String nameTestIngredient = "Ketchunez";
    float priceTestIngredient = 0.2022F;
    IngredientType typeTestIngredient = IngredientType.SAUCE;

    @Before
    public void setUp() {
        ingredient = new Ingredient(typeTestIngredient, nameTestIngredient, priceTestIngredient);
    }

    @Test
    public void getPriceIngredient() {
        float actual = ingredient.getPrice();
        assertEquals(priceTestIngredient, actual, 0);
    }

    @Test
    public void getNameIngredient() {
        String actual = ingredient.getName();
        assertEquals(nameTestIngredient, actual);
    }

    @Test
    public void getTypeIngredient() {
        IngredientType actual = ingredient.getType();
        assertEquals(typeTestIngredient, actual);
    }
}