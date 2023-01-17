import org.junit.Assert;
import org.junit.Test;

import praktikum.Ingredient;
import praktikum.IngredientType;


public class IngredientTest {

    private IngredientType type;

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals("test",ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals(2.5f,ingredient.getPrice(),0);
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type,"test", 2.5f);
        Assert.assertEquals(type,ingredient.getType());
    }
}
