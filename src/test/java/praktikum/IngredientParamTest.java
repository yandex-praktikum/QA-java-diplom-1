package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {

    private final IngredientType actualType;
    private final IngredientType expectedType;
    private final String actualName;
    private final String expectedName;
    private final float actualPrice;
    private final float expectedPrice;

    public IngredientParamTest(IngredientType actualType, IngredientType expectedType, String actualName, String expectedName, float actualPrice, float expectedPrice) {
        this.actualType = actualType;
        this.expectedType = expectedType;
        this.actualName = actualName;
        this.expectedName = expectedName;
        this.actualPrice = actualPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientParam() {
        return new Object[][] {
                {null, null, null, null, 0f, 0f},
                {SAUCE, SAUCE, "", "", 100.25f, 100.25f},
                {SAUCE, SAUCE, "Терияки", "Терияки", -10.14f, -10.14f},
                {FILLING, FILLING, "  ", "  ", 100.25f, 100.25f},
                {FILLING, FILLING, "Мсяо", "Мсяо", -10.14f, -10.14f},
        };
    }

    private Ingredient actualIngredient;

    @Before
    public void setup() {
        actualIngredient = new Ingredient(actualType, actualName, actualPrice);
    }

    @Test
    public void testGetType(){
        assertEquals(expectedType, actualIngredient.getType());
    }

    @Test
    public void testGetName(){
        assertEquals(expectedName, actualIngredient.getName());
    }

    @Test
    public void testGetPrice(){
        assertEquals(expectedPrice, actualIngredient.getPrice(), 0);
    }

}
