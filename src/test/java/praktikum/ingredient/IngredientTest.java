package praktikum.ingredient;

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

    private IngredientType type;
    private String name;
    private float price;

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {FILLING, "Салат", 2.0F},
                {SAUCE, "Сальса", 3.0F},
                {FILLING, "Котлета", 7.0F}
        };
    }

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void checkIngredientValues() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Invalid ingredient type", type, ingredient.getType());
        assertEquals("Invalid name", name, ingredient.getName());
        assertEquals("Invalid price", price, ingredient.getPrice(), 0.0F);
    }

}
