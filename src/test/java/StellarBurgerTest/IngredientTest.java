package StellarBurgerTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType testType;
    private final String testName;
    private final float testPrice;

    public IngredientTest(IngredientType testType, String testName, float testPrice) {
        this.testType = testType;
        this.testName = testName;
        this.testPrice = testPrice;
    }

    @Parameterized.Parameters(name = "Test {index}, Test data: {0} - {1} - {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "cosmic_space", 1.15f},
                {FILLING, "stars", 0.75f},
        };
    }

    @Test
    @DisplayName("Ingredient creating test")
    @Description("Created ingredient must have correct type, name and price")
    public void createIngredientTest() {
        Ingredient testIngredient = new Ingredient(testType, testName, testPrice);
        Assert.assertEquals("correct ingredient type", testIngredient.getType(), testType);
        Assert.assertEquals("correct ingredient name",testIngredient.getName(), testName);
        Assert.assertEquals("correct ingredient price", testIngredient.getPrice(),testPrice,0.0001);
    }
}
