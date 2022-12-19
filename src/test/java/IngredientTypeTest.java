import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void getTypeOfIngredient() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}
