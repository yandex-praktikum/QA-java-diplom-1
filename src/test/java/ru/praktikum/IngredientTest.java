package ru.praktikum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    public final IngredientType type;
    public final String name;
    public final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getDataIngredient(){
        return new Object[][] {
                {IngredientType.FILLING, "cutlet", 450},
                {IngredientType.SAUCE, "Cheesy", 7.5F},
        };
    }

    @Test
    public void getPriceReturnCorrectPriceIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Incorrect ingredient price", price, actualPrice, 0);
    }

    @Test
    public void getNameReturnCorrectNameIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        Assert.assertEquals("Incorrect ingredient name", name, actualName);
    }

    @Test
    public void getTypeReturnCorrectTypeIngredient(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Incorrect ingredient type", type, actualType);
    }
}
