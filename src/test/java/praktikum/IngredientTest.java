package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final Ingredient ingredient;
    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(
            Ingredient ingredient,
            IngredientType expectedType,
            String expectedName,
            float expectedPrice
    ) {
        this.ingredient = ingredient;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Ingredient(IngredientType.SAUCE, "Ketchup", 1.0f), IngredientType.SAUCE, "Ketchup", 1.0f},
                {new Ingredient(IngredientType.FILLING, "Chicken", 2.5f), IngredientType.FILLING, "Chicken", 2.5f},
        });
    }

    @Test
    public void testGetPrice() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(expectedType, ingredient.getType());
    }
}
