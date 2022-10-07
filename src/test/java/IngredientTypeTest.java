import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void returnSauceType(){
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void returnFillingType(){
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}