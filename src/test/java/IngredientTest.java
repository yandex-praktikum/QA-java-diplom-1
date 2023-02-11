import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    Ingredient ingredient;

    @Before
    public void createIngredient(){
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice){
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    @Parameterized.Parameters
    public static Object[][] setupIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Test
    public void checkGetTypePositive(){
        IngredientType actual = ingredient.getType();
        assertEquals(expectedType, actual);
    }

    @Test
    public void checkGetNamePositive(){
        String actualIngredientName = ingredient.getName();
        assertEquals(expectedName, actualIngredientName);
    }

    @Test
    public void checkGetPricePositive(){
        float actual = ingredient.getPrice();
        assertEquals(expectedPrice, actual, 0.0001F);
    }

}
