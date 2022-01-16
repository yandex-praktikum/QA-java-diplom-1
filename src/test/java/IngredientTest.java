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
    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
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
        String actualName = ingredient.getName();
        Assert.assertEquals(actualName, name);
    }

    @Test
    public void testGetPrice() {
        float actualPrice = ingredient.getPrice();
        Assert.assertTrue(actualPrice == price);
    }

    @Test
    public void testIngredientType() {
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals(actualIngredientType, type);
    }
}
