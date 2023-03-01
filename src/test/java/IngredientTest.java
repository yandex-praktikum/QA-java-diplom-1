import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    private Ingredient ingredient1;
    private static final String ING_NAME = "Сыр";
    private static final float ING_PRICE = 10.55f;
    private static final IngredientType ING_TYPE = SAUCE;

    @Before
    public void setUp() {
        ingredient1 = new Ingredient(ING_TYPE, ING_NAME, ING_PRICE);
    }
    @Test
    public void getPriceTest() {
        assertEquals(ING_PRICE, ingredient1.getPrice(), 0.0001);
    }

    @Test
    public void getNameTest() {
        assertEquals(ING_NAME, ingredient1.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(ING_TYPE, ingredient1.getType());
    }
}
