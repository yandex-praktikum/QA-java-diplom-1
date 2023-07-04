package praktikum.stellar_burgers;

import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    IngredientType firstType = SAUCE;
    IngredientType secondType = FILLING;

    @Test
    public void ingredientValues() {
        IngredientType[] allType = IngredientType.values();
        assertEquals(firstType, allType[0]);
        assertEquals(secondType, allType[1]);

    }

    @Test
    public void ingredientValueOf() {
        IngredientType firstActual = IngredientType.valueOf(firstType.toString());
        IngredientType secondActual = IngredientType.valueOf(secondType.toString());
        assertEquals(firstType, firstActual);
        assertEquals(secondType, secondActual);
    }
}
