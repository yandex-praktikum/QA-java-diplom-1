package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    IngredientType type = IngredientType.FILLING;
    String name = "cutlet";
    float price = 100;

    @Test
    public void ingredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float expected = 100;
        Assert.assertEquals(expected, ingredient.getPrice(), 0f);
    }

    @Test
    public void ingredientNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String expected = "cutlet";
        Assert.assertEquals(expected, ingredient.getName());
    }

    @Test
    public void ingredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }

}