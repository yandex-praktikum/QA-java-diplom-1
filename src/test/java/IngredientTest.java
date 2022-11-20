import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(SAUCE, "chili sauce", 300);
    }

    @Test // тест метода цены ингридиента
    public void getNameTest() {
        assertEquals("chili sauce", ingredient.getName());
    }
    @Test // тест метода названия ингридиента
    public void getPriceTest() {
        assertEquals(300F, ingredient.price, 0);
    }
    @Test // тест метода типа ингридиента
    public void getTypeTest() {
        assertEquals(SAUCE, ingredient.getType());
    }
}