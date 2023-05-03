package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "ketchup";
    private final float price = 270.0f;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, name, price);
    }

    @Test
    public void getNameTest() {
        String actual = ingredient.getName();
        assertEquals("Верное название ингредиента",name, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = ingredient.getPrice();
        assertEquals("Неверный тип ингридиента",price, actual, 0f);
    }
}
