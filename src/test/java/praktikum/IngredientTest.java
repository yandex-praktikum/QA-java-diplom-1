package praktikum;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    @org.junit.runners.Parameterized.Parameter(0)
    public IngredientType type;
    @org.junit.runners.Parameterized.Parameter(1)
    public String name;
    @org.junit.runners.Parameterized.Parameter(2)
    public float price;
    @org.junit.runners.Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] params() {
        return new Object[][]{
                {SAUCE, "острый", 500},
                {FILLING, "сыр", 600},
        };
    }
    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice,0);
    }
    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(type, actualType);
    }
}
