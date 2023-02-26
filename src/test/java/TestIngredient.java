import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestIngredient {

    private final IngredientType type;
    private final String name;
    private final float price;

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    private Ingredient ingredient;


    public TestIngredient(IngredientType type, String name, float price, IngredientType expectedType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100.0f, SAUCE, "hot sauce", 100.0f},
                {SAUCE, "sour cream", 200.0f, SAUCE, "sour cream", 200.0f},
                {SAUCE, "chili sauce", 300.0f, SAUCE, "chili sauce", 300.0f},
                {FILLING, "cutlet", 100.0f, FILLING, "cutlet", 100.0f},
                {FILLING, "dinosaur", 200.0f, FILLING, "dinosaur", 200.0f},
                {FILLING, "sausage", 300.0f, FILLING, "sausage", 300.0f}
        };

    }

    @Before
    public void preparationIngredients() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGiveTypeOfIngredient() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(expectedType, actualIngredientType);
    }

    @Test
    public void testGivePriceOfIngredient() {
        float actualIngredientPrice = ingredient.getPrice();
        int delta = 2;
        assertEquals(expectedPrice, actualIngredientPrice, delta);
    }

    @Test
    public void testGiveNameOfIngredient() {
        String actualIngredientName = ingredient.getName();
        assertEquals(expectedName, actualIngredientName);
    }

}
