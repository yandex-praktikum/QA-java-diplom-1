package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestIngredientWithParams {
    private final IngredientType passedType;
    private final String passedName;
    private final float passedPrice;

    public TestIngredientWithParams(IngredientType passedType, String passedName, float passedPrice) {
        this.passedType = passedType;
        this.passedName = passedName;
        this.passedPrice = passedPrice;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][] {
                { IngredientType.SAUCE, "Табаско", 30.80f },
                { IngredientType.FILLING, "Котлета", 50.0f },
                { IngredientType.FILLING, "Зелень", 0.0f }
                , { null, null, 0.0f }
        };
    }

    @Test
    public void testGetPriceReturnsPassedPrice() {
        Ingredient ingredient = new Ingredient(passedType, passedName, passedPrice);
        assertNotNull(ingredient);
        assertEquals(passedPrice, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetNameReturnsPassedName() {
        Ingredient ingredient = new Ingredient(passedType, passedName, passedPrice);
        assertNotNull(ingredient);
        assertEquals(passedName, ingredient.getName());
    }

    @Test
    public void testGetTypeReturnsPassedType() {
        Ingredient ingredient = new Ingredient(passedType, passedName, passedPrice);
        assertNotNull(ingredient);
        assertEquals(passedType, ingredient.getType());
    }
}