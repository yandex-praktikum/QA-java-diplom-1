package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String name;
    private final float price;
    public IngredientTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                {"белый", 50F},
                {"ketchup", 15},
                {"@#$%^$", 15.500},
                {"", 3}
        };
    }

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "соус 1", price);
        float actPrice = ingredient.getPrice();
        Assert.assertEquals(price, actPrice, 0);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, 10F);
        String actName = ingredient.getName();
        Assert.assertEquals("Имя ингридиента не верное", name, actName);
    }
}