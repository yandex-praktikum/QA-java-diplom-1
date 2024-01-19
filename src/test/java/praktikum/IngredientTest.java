package praktikum;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import static praktikum.IngredientType.SAUCE;
public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setIngredient(){
        ingredient = new Ingredient(SAUCE, "sour cream", 200.0f);
    }

    @Test
    public void getTypeTest() {
        IngredientType type = ingredient.getType();
        assertEquals(SAUCE, type);
    }

    @Test
    public void getNameTest(){
        String name = ingredient.getName();
        assertEquals("sour cream", name);
    }

    @Test
    public void getPriceTest(){
        float price = ingredient.getPrice();
        assertEquals(200.0f, price);
    }
}