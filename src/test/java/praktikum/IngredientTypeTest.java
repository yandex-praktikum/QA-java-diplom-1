package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTypeTest (IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Name ingredient: {1}")
    public static Object[][] ingredientTypeTestParameters() {
        return new Object[][]{
                {SAUCE, "hot sauce", 10F},
                {FILLING, "cutlet", 30F},

        };
    }

    @Test
    public void checkIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}