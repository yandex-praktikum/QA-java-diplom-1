package praktikum;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createNewIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
    }

    @Test
    public void getIngredientNameTest() {
        String expected = "sausage";
        assertEquals("Неверное имя ингредиента", expected, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        float expected = 300;
        assertEquals("Неверное цена ингредиента", expected, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType expected = IngredientType.FILLING;
        assertEquals("Неверный тип ингредиента", expected, ingredient.getType());
    }
}
