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
public class IngredientParameterizedTest {
    private final IngredientType type;
    private Ingredient ingredient;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор параметров {index}, параметры: {0} - {1} - {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {null, "cutlet", 100},
                {FILLING, "", 2},
                {null, null, 0}
        };
    }

    @Before
    public void startTest() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetValidPrice() {
        assertEquals("invalid price", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void checkGetValidName() {
        assertEquals("invalid name", name, ingredient.getName());
    }

    @Test
    public void checkGetValidType() {
        assertEquals("invalid type", type, ingredient.getType());

    }
}