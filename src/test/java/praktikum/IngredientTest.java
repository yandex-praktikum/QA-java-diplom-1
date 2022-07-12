package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
    public void initObject() {
        ingredient = new Ingredient(type,name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] getIngredientsParams() {
        return new Object[][] {
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sour cream", 200f},
                {SAUCE, "chili sauce", 300f},
                {FILLING, "cutlet", 100f},
                {FILLING, "dinosaur", 200f},
                {FILLING, "sausage", 300f},
        };
    }

    @Test
    public void shouldGetIngredientType() {
        IngredientType actual = ingredient.getType();
        assertEquals("Get ingredient type error", type, actual);
    }

    @Test
    public void shouldGetIngredientName() {
        String actual = ingredient.getName();
        assertEquals("Get ingredient name error", name, actual);
    }

    @Test
    public void shouldGetIngredientPrice() {
        float actual = ingredient.getPrice();
        assertEquals("Get ingredient price error", price, actual, 0.0);
    }
}
