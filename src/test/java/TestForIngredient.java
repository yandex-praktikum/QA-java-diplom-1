import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestForIngredient {
    private static final String SAUCE_NAME = "chili sauce";
    private static final float SAUCE_PRICE = 300;
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

    @Test
    public void checkTheName() {
        assertEquals(SAUCE_NAME, ingredient.getName());
    }

    @Test
    public void checkThePrice() {
        assertEquals(SAUCE_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void checkTheType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
