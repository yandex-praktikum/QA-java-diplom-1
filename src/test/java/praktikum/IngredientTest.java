package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static praktikum.Constant.*;
import static praktikum.Message.*;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void newIngredient (){
        ingredient = new Ingredient(IngredientType.FILLING,CUTLET,CUTLET_PRICE);
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(WRONG_PRICE_MSG, CUTLET_PRICE, ingredient.getPrice(), DELTA);
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals(WRONG_NAME_MSG, CUTLET, ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        Assert.assertEquals(WRONG_TYPE_MSG,IngredientType.FILLING, ingredient.getType());
    }
    @Test
    public void getPriceNegativeTest(){
        Assert.assertNotEquals(FAKE_EQUAL_PRICE_MSG, FAKE_PRICE, ingredient.getPrice(), DELTA);
    }
    @Test
    public void getNameNegativeTest(){
        Assert.assertNotEquals(FAKE_EQUAL_NAME_MSG,FAKE_FILLING,ingredient.getName());
    }
    @Test
    public void getTypeNegativeTest(){
        Assert.assertNotEquals(FAKE_EQUAL_TYPE_MSG,FAKE_TYPE, ingredient.getType());
    }
}
