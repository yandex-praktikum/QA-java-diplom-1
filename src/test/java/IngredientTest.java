
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

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][]{
                {SAUCE, "Gorchitsa", 500f},
                {FILLING, "myaso", 700.10f}
        };
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Incorrect type", ingredientType, actualType);
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Incorrect name", name, actualName);
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Incorrect price", price, actualPrice, 0);
    }


}
