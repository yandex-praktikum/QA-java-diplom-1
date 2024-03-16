import org.junit.Test;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

public class IngredientTypeTest {
    @Test
    public void testEnumIngredientType(){
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}
