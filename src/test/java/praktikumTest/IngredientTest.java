package praktikumTest;

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
    private final String expType;


    public IngredientTest(IngredientType ingredientType, String name, float price, String expType) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
        this.expType = expType;
    }

    @Parameterized.Parameters (name = "Iteration #{index} -> IngredientType = {0}, Name = {1}, Price = {2}")
    public static Object[][] getTestData() {
        return new Object[][] {
                { FILLING, "Salad", 10, "FILLING"},
                { SAUCE, "Ketchup", 1.5f, "SAUCE"},
        };
    }

    @Test
    public void checkTypeIsValueOfEnum() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(IngredientType.valueOf(expType), ingredient.getType());
    }

    @Test
    public void setCorrectPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0);
    }
}

