import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


public class TestsIngredient {

    private Ingredient ingredient;
    @Before
    public void setUp(){
        ingredient = new Ingredient(SAUCE, "Кепчук",19.99f);
    }

    @Test
    public void testIngredientGetPrice(){
        assertEquals(19.99f,ingredient.getPrice(),0.0);
    }
    @Test
    public void testIngredientGetName(){
        assertEquals("Кепчук", ingredient.getName());
    }
}
