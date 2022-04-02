import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;
public class IngredientTypeTest {

    @Test
    public void typeSauce() {
        IngredientType expectedType = IngredientType.SAUCE;
        assertEquals("Incorrect type",IngredientType.valueOf("SAUCE"), expectedType);
    }

    @Test
    public void typeFilling () {
        IngredientType expectedType = IngredientType.FILLING;
        assertEquals("Incorrect type",IngredientType.valueOf("FILLING"), expectedType);
    }
}
