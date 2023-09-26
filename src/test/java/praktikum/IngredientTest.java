package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }
    Ingredient ingredient;

        @Before
    public void createIngredient() {
            ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        }

@Parameterized.Parameters
public static Object[][] getIngredient(){
    return new Object[][] {
            {IngredientType.SAUCE, "hot sauce", 100},
            {IngredientType.SAUCE, "sour cream", 200},
            {IngredientType.SAUCE, "chili sauce", 300},
            {IngredientType.FILLING, "cutlet", 100},
            {IngredientType.FILLING, "dinosaur", 200},
            {IngredientType.FILLING, "sausage", 300},
    };
}

    @Test
    public void testIngredientGetPrice() {
        float actualPrice = ingredient.getPrice();
        assertEquals("wrong ingredient's price", expectedPrice, actualPrice, 0);
    }

    @Test
    public void testIngredientGetName() {
        String actualName = ingredient.getName();
        assertEquals("wrong ingredient's name",expectedName, actualName);
    }

    @Test
    public void testIngredientGetType() {
        IngredientType actualType = ingredient.getType();
        assertEquals("wrong ingredient's type", expectedType, actualType);
    }
}