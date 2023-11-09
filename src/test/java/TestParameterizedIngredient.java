import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class TestParameterizedIngredient {
    private final IngredientType type;
    private final String name;
    private final float price;
    Ingredient ingredient;

    public TestParameterizedIngredient(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {null, "cutlet", 100},
                {FILLING, "", 0},
                {FILLING, null, 23.1111f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void createGetPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void createGetName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void createGetType() {
        Assert.assertEquals(type, ingredient.getType());

    }

}
