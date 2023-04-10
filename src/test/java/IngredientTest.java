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
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Before
    public void SetUp() {
    ingredient = new Ingredient(type, name, price);
    }
    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 0.0f},
                {SAUCE, "cheese sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "vegetables", 200},
                {FILLING, "sausage", 300},
        };
    }

    @Test
    public void getPriceTest() {
        assertEquals("Sorry, price incorrect", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameTest() {
        assertEquals("Sorry, name incorrect", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Sorry, type incorrect", type, ingredient.getType());
    }
}
