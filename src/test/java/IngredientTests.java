import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    private Ingredient ingredient;
    private static final double DELTA = 1e-15;

    @Before
    public  void createIngredient(){
        ingredient = new Ingredient(IngredientType.SAUCE,"Томатный", 5.123f);
    }

    @Test
    public void shouldGetName(){

        String actual = ingredient.getName();
        String expected = "Томатный";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPrice(){

        float actual = ingredient.getPrice();
        float expected = 5.123f;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void shouldGetType(){

        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }

}
