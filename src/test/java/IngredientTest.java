import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "kepchuk";
    private final float price = 250.0f;
    private Ingredient ingredient;

    @Before
    public void createInstance() {
        ingredient = new Ingredient(IngredientType.SAUCE, name, price);
    }

    @Test
    public void getNameTest() {
        String actual = ingredient.getName();
        assertEquals("Правильное название ингредиента",name, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = ingredient.getPrice();
        assertEquals("Неверный ингридиент",price, actual, 0f);
    }
}
