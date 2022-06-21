package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    private final IngredientType expectedType = IngredientType.SAUCE;
    private final String expectedName = "Традиционный соус";
    private final float expectedPrice = 12.2F;

    @Test
    public  void testGetPrice () {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Price is incorrect",expectedPrice, actualPrice, 0);
    }

    @Test
    public void testGetName (){
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        String actualName = ingredient.getName();
        Assert.assertEquals("Name is incorrect" , expectedName, actualName);

    }

    @Test
    public  void testGetType (){
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("Type is incorrect", expectedType, actualType);
    }

}