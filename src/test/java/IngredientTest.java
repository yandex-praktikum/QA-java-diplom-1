import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;
import static praktikum.IngredientType.FILLING;

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

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        Object[][] objects = {
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sour cream", 200f},
                {SAUCE, "chili sauce", 300f},
                {FILLING, "cutlet", 100f},
                {FILLING, "dinosaur", 200f},
                {FILLING, "sausage", 300f},
                {null, "ййцуЙУ", 666f},
                {SAUCE, "", 2f},
                {FILLING, null, 15.08f},
                {SAUCE, "123qQЦц-ф12Хъэ", Float.NaN}
        };
        return objects;
    }

    @Before
    public void startTest() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetType() {
        assertEquals("Ошибка типа", type, ingredient.getType());
    }

    @Test
    public void checkGetName() {
        assertEquals("Ошибка имени", name, ingredient.getName());
    }

    @Test
    public void checkGetPrice() {
        assertEquals("Ошибка цены", price, ingredient.getPrice(), 0.0f);
    }
}