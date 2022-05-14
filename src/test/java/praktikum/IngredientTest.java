package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    public IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE, "hot sauce", 100},
        };
    }

    @Before
    public void init() {
        this.ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getTypePriceTest() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void getIngredientPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getIngredientNameTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

}
