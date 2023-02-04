package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "test ingredient", 155.30f);
    }

    @Test
    public void getPriceShouldReturnExpectedPrice() {
        float expectedPrice  = 155.30f;
        assertEquals(expectedPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getNameShouldReturnExpectedName() {
        String expectedName  = "test ingredient";
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeShouldReturnExpectedType() {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
