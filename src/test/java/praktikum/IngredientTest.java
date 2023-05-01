package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {
    private String name = "Meat";
    private float price= (float) 15.45;

    private IngredientType type = IngredientType.SAUCE;

    @Test
    public void IngredientGetPrice() {
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(price,ingredient.getPrice(), 0.0f);
    }

    @Test
    public void IngredientGetName() {
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(name,ingredient.getName());
    }

    @Test
    public void IngredientGetType() {
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(type,ingredient.getType());
    }

}
