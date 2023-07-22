import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getIngredients() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Ketchup", 1.0f},
                {IngredientType.FILLING, "Cheese", 12.9f},
                {IngredientType.SAUCE, "Mayonnaise", 1.01f},
                {IngredientType.FILLING, "Tomato", 0.5f},
                {IngredientType.SAUCE, "Mustard", 5.5f},
        });
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
