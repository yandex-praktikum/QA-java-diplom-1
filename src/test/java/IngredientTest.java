import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "";
    private final float price = 10;
    private Ingredient ingredient;
    private IngredientType type;

    @Before
    public void Ingredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }
}
