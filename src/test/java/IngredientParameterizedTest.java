import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
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

    @Parameterized.Parameters()
    public static Collection<Object[]> setData() {
        return Arrays.asList(new Object[][] {
                {SAUCE, "hot sauce", 100f},
                {SAUCE, "sour cream", 200f},
                {SAUCE, "chili sauce", 300f},
                {SAUCE, "острый соус", -10f},
                {SAUCE, "10.5", 10.5f},
                {FILLING, "cutlet", 100f},
                {FILLING, "dinosaur", 200f},
                {FILLING, "sausage", 300f},
                {FILLING, "", 0f},
        });
    }

    @Before
    public void startTest() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetValidPrice() {
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void testGetValidName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGettValidType() {
        assertEquals(type, ingredient.getType());

    }
}