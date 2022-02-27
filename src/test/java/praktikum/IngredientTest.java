package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceTest(){
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(100, actualPrice, 0);
    }

    @Test
    public void getNameTest(){
        String actualName = ingredient.getName();
        Assert.assertEquals("Некоректное имя", "hot sauce", actualName);
    }

    @Test
    public void getTypeTest(){
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(IngredientType.SAUCE, actualType);
    }
}