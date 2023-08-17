import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    private final float expectedPrice;
    private final String expectedName;
    private final IngredientType expectedType;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 50f, "testFilling", IngredientType.FILLING },
                { 75f, "mockFilling", IngredientType.FILLING },
        });
    }

    public IngredientTest(float expectedPrice, String expectedName, IngredientType expectedType) {
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
        this.expectedType = expectedType;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
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
