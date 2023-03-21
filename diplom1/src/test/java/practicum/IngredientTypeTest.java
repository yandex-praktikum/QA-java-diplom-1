package practicum;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    @Test
    public void thereShouldBeTwoIngredientTypes() {
        int amountOfIngredientTypes = IngredientType.values().length;
        assertEquals(2, amountOfIngredientTypes);
    }
}
