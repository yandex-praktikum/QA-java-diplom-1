import org.junit.Assert;
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
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] setIngredient() {
        return new Object[][]{
                {SAUCE, "T", 1},
                {FILLING, null, 0},
                {SAUCE, "TestName", -1},
                {FILLING, "", -0.1F}
        };
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertTrue(actualPrice == price);
    }

    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals(actualIngredientType, type);
    }
}
