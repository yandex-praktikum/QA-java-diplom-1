package praktikum;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

import static org.junit.Assert.*;

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

    @Parameterized.Parameters(name = "Test: {0} | {1} | {2}")
    public static Object[][] testData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", -300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", Float.MIN_VALUE},
                {FILLING, "sausage", Float.MIN_VALUE}
        };
    }


    @Test
    public void checkGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ingredient price is incorrect", ingredient.getPrice(), price, 0);
    }

    @Test
    public void checkGetIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ingredient name is incorrect", ingredient.getName(), name);
    }

    @Test
    public void checkGetIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ingredient type is incorrect", ingredient.getType(), type);
    }
}