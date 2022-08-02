package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    CreateRandomIngredient randomIngredient = new CreateRandomIngredient();
    Ingredient ingredient;

    private final IngredientType type = randomIngredient.getIngredients().getType();
    private final String name = randomIngredient.getIngredients().getName();
    private final float price = randomIngredient.getIngredients().getPrice();

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getType() {
        IngredientType actual = ingredient.getType();

        assertEquals(actual, type);
    }

    @Test
    public void getName() {
        String actual = ingredient.getName();

        assertEquals(actual, name);
    }

    @Test
    public void getPrice() {
        float actual = ingredient.getPrice();

        assertEquals(actual, price, 0);
    }

}