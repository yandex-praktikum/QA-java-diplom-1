import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void shouldGetIngredientType() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}