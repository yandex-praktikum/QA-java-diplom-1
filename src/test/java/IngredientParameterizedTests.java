import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTests {
    private final IngredientType expectedType;

    private final String expectedName;
    private final float expectedPrice;

    public IngredientParameterizedTests(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;

    }
    Ingredient ingredient;

    @Parameterized.Parameters(name = "{0}, {1}, {2}")
    public static Object[][] ingredient(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100F},
                {IngredientType.SAUCE, "sour cream", 200F},
                {IngredientType.SAUCE, "chili sauce", 300F},
                {IngredientType.FILLING, "cutlet", 100F},
                {IngredientType.FILLING, "dinosaur", 200F},
                {IngredientType.FILLING, "sausage", 300F},
        };
    }
    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }
    @Test
    public void ingredientGetPriceTest() {
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
    @Test
    public void ingredientGetNameTest() {
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    public void ingredientsGetTypeTest() {
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
}
