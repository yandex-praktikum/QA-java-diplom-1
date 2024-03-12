package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Database database = new Database();
    Ingredient ingredient = new Ingredient(database.availableIngredients().get(0).getType(), database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice());

    @Test
    public void getIngredientPrice(){
        Assert.assertEquals(100F, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientName(){
        Assert.assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getIngredientType(){
        Assert.assertEquals(SAUCE, ingredient.getType());
    }
}