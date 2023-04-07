package praktikumtests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp(){
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
    }
    @Test
    public void getPriceTest(){
        Assert.assertEquals(100, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals( "cutlet", ingredient.getName());
    }
    @Test
    public void getTypeTest(){
       Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}


