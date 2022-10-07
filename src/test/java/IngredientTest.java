import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    private String name = "Ingredient";
    private float price = 1.23f;
    private Ingredient ingredient;

    @Mock
    IngredientType type;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void shouldGetPrice() {
        assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void shouldGetName() {
        assertEquals(name, ingredient.getName());
    }

}
