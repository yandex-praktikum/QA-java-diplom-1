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
public class IngredientTest {

    private final IngredientType testType;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType testType, String name, float price) {
        this.testType = testType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test values: Type ingredient - {0} Name - {1} Price - {2}")
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {FILLING, "chicken", 350.0f},
                {SAUCE, "caesar", 180.0f},
                {FILLING, "meat", 320.0f},
                {SAUCE, "BBQ", 200.0f},
                {FILLING, "dinosaur", 380.0f},
                {FILLING, "cutlet", 230.0f},
                {FILLING, "sausage", 150.0f},
                {SAUCE, "hot sauce", 90.0f},
                {SAUCE, "sour cream", 110.0f},
                {SAUCE, "chili sauce", 80.0f},
                {FILLING, null, 0.0f},
                {null, "caesar", 0.0f},
                {null, null, 129.0f}
        };
    }

    @Before
    public void testIngredientStart() {
        ingredient = new Ingredient(testType, name, price);
    }

    @Test
    public void testIngredientGetName() {
        assertEquals("Incorrect name", name, ingredient.getName());
    }

    @Test
    public void testIngredientGetPrice() {
        ingredient = new Ingredient(testType, name, price);
        assertEquals("Incorrect price", price, ingredient.getPrice(), 0);
    }
}