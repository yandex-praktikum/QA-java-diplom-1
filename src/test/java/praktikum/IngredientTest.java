package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String expectedName;
    private float expectedPrice;

    Ingredient ingredient;

    public IngredientTest (IngredientType type, String expectedName, float expectedPrice) {
        this.type = type;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData () {
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
    public void checkDataValue() {

        Ingredient ingredient = new Ingredient(type, expectedName, expectedPrice);

        IngredientType ingredientType = ingredient.getType();
        String actualName = ingredient.getName();
        float actualPrice = ingredient.getPrice();

        assertEquals("The type is not correct", type, ingredientType);
        assertEquals("The name is not correct", expectedName, actualName);
        assertEquals("The price is not correct", expectedPrice, actualPrice,0);
    }
}
