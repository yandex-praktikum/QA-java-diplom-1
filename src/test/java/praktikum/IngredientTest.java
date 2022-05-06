package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest implements SetUp {
    private Ingredient ingredient;
    private final String expectedName;
    private final float expectedPrice;
    private final IngredientType expectedType;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }


    @Override
    @Before
    public void createObject() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] IngredientTestData() {
        return new Object[][]{
                {SAUCE, "T", 100},
                {FILLING, "Кириллица", 0.1f},
                {null, null, 0},
                {SAUCE, " ТЕСТ", 2.99f},
                {FILLING, "!@# ", 999999999.999f},
                {null, "Test Name", -0.01f}
        };
    }

    @Test
    public void getNameParameterizedParametersGetValue() {
        String actualName = ingredient.getName();
        Assert.assertEquals("Incorrect name", expectedName, actualName);
    }

    @Test
    public void getPriceParameterizedParametersGetValue() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Incorrect price", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getIngredientTypeParameterizedParametersGetValue() {
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Incorrect type", expectedType, actualType);
    }
}
