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
public class IngredientTest {
    private final IngredientType type;
    private Ingredient ingredient;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "Tanuki", 100},
                {FILLING, null, 0},
                {SAUCE, "Tanuki", -1},
                {FILLING, "", -0.1F}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkGetName() {
        String actualName = ingredient.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void checkGetPrice() {
        float actuaPrice = ingredient.getPrice();
        Assert.assertTrue(actuaPrice == price);
    }

    @Test
    public void checkGetType() {
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals(actualIngredientType, type);
    }
}
