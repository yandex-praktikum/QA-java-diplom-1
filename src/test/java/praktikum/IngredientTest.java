package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class IngredientTest {

    private Ingredient ingredient;
    private String name = "string";
    private float price = 2.28F;

    @Mock
    IngredientType ingredientType;

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getPrice() {
        assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getName() {
        assertEquals(name, ingredient.getName());
    }
}