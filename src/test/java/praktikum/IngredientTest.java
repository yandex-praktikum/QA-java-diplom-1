package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static config.PriceNameData.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test: {0}")
    public static Object[][] ingredientData() {
        return new Object[][]{
                { SAUCE, NAME_INGREDIENT, PRICE },
                { SAUCE, NAME_INGREDIENT_SAUCE, PRICE_INGREDIENT_SAUCE },
                { SAUCE, NAME_INGREDIENT_FILLING, PRICE_INGREDIENT_SAUCE },
                { FILLING, NAME_INGREDIENT_FILLING, PRICE_INGREDIENT },
                { FILLING, "", PRICE_INGREDIENT_FILLING },
                { FILLING, NAME_INGREDIENT, PRICE_INGREDIENT_FILLING },
                { null, null, 0 },
                { SAUCE, "a", Float.MIN_VALUE },
                { FILLING, NAME_INGREDIENT, Float.MAX_VALUE },
                { FILLING, NAME_INGREDIENT, -Float.MAX_VALUE }
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetPrice() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        assertEquals("Цена ", expectedPrice, actualPrice, 0);
        System.out.println(expectedPrice);
        System.out.println(actualPrice);
    }

    @Test
    public void checkGetName() {
        String expectedName = name;
        String actualName = ingredient.getName();
        assertEquals("Название", expectedName, actualName);
        System.out.println(expectedName);
        System.out.println(actualName);
    }

    @Test
    public void checkGetType() {
        IngredientType expectedType = type;
        IngredientType actualType = ingredient.getType();
        assertEquals("Ингридиент", expectedType, actualType);
        System.out.println(expectedType);
        System.out.println(actualType);
    }
}