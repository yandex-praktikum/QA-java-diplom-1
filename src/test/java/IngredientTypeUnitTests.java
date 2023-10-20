import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeUnitTests {

    @Test
    public void chooseSauceAsIngredientType() {

        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void chooseFillingAsIngredientType() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
