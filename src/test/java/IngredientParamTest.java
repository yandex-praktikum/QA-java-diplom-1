import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "mustard", 200},
                {SAUCE, "cheese", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "ketchup", 200},
                {FILLING, "sausage", 300},

        };
    }
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}

