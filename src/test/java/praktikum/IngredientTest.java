package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    IngredientType type;
    String name;
    float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.FILLING, "sausage", 300},
            };
        }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetPriceReturnsCorrectPrice() {
        Assert.assertEquals("Ingredient's price should be " + price, price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetNameReturnsCorrectName() {
        Assert.assertEquals("Ingredient's name should be " + name, name, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals("Ingredient's type should be " + type, type, ingredient.getType());
    }
}