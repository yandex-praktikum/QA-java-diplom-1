import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void sauceShouldBeSelected() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void fillingShouldBeSelected() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}