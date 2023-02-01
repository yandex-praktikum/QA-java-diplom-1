import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;

    private IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredentPrice;
    private final IngredientType expectedIngredientType;
    private final String expectedIngredientName;
    private final float expectedIngredentPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredentPrice, IngredientType expectedIngredientType, String expectedIngredientName, float expectedIngredentPrice) {        this.ingredientType = ingredientType;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredentPrice = ingredentPrice;
        this.expectedIngredientType = expectedIngredientType;
        this.expectedIngredientName = expectedIngredientName;
        this.expectedIngredentPrice = expectedIngredentPrice;
    }

    @Parameterized.Parameters
    public static Object[][] bunTestData() {
        return new Object[][] {
                {SAUCE, "соус", 1.0000001f, SAUCE, "соус", 1.0000001f},
                {FILLING, "", 0, FILLING, "", 0},
                {SAUCE, "!@#$%^&*()_+", -1100.50f, SAUCE, "!@#$%^&*()_+", -1100.50f},
                {FILLING, "filling", 3402823466.1059f, FILLING, "filling", 3402823466.1059f}
        };
    }

    @Before
    public void initialize() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredentPrice);
    }

    @Test
    public void getNameReturnsCorrectValue() {
        Assert.assertEquals("Неверная работа метода getName", expectedIngredientName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Assert.assertEquals("Неверная работа метода getPrice", expectedIngredentPrice, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getTypeReturnsCorrectValue() {
        Assert.assertEquals("Неверная работа метода getType", expectedIngredientType, ingredient.getType());
    }

}
