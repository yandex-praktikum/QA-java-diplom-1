package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;


public class IngredientTest {

    @Test
    public void getPrice() throws Exception {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"Майонез",20F);
        float actual = ingredient.getPrice();
        float  expected = 20F;
        assertEquals(expected, actual, 0.0F);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,"Варенье",30F);
        String actual = ingredient.getName();
        String expected = "Варенье" ;
        assertEquals(expected,actual) ;
    }

}