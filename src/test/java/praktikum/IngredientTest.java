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
                {"белый", 50f},
                {"ketchup", 15},
                {"@#$%^$", 150},
                {"", 3}
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(null, "соус 1", price);
        float actPrice = ingredient.getPrice();
        Assert.assertEquals(price, actPrice, 0);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(null, name, 10f);
        String actName = ingredient.getName();
        Assert.assertEquals("Имя ингридиента не верное", name, actName);
    }
    @Test
    public void getTypeIngredientTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Соус", 10f);
        Assert.assertEquals("Некорректный результат", IngredientType.FILLING, ingredient.getType());
    }
}