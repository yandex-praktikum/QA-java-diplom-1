package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cutlet", 200);

    @Test
    public void getIngredientPrice(){
        float actual = ingredient.getPrice();
        float expected = 200;
        assertEquals(expected, actual,0);
    }

    @Test
    public void getIngredientNameTest() {
        String actual = ingredient.getName();
        String expected = "cutlet";
        assertEquals(expected, actual);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }
}