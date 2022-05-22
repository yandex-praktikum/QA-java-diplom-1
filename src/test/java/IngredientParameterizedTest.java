import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private IngredientType type;
    private final String name;
    private final float price;

    public IngredientParameterizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsData() {
        return new Object[][]{
                {FILLING, "Биокотлета", 210.15f},
                {SAUCE, "Spicy-X", 199.99f},
                {FILLING, "Говяжий метеорит", 313.35f},
                {SAUCE, "Традиционный", 34.45f}
        };
    }

    @Test
    public void isIngredientsDataValid() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertThat(ingredient.getType(), anyOf(is(FILLING), is(SAUCE)));
        assertNotNull(ingredient.getName());
        assertTrue(ingredient.getPrice() > 0);
    }
}

